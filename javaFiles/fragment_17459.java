public class Test {

  private static final Gson GSON = new Gson();

  public static <T> T convert(String urlencoded, Type type) {
    try {
      Map<String, Object> map = asMap(urlencoded);
      String json = GSON.toJson(containsList(map) ? map.values() : map);
      return GSON.fromJson(json, type);
    }
    catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private static boolean containsList(Map<String, Object> map) {
    return !map.isEmpty() && new ArrayList<>(map.keySet()).get(0).contains("[");
  }

  public static Map<String, Object> asMap(String urlencoded) throws UnsupportedEncodingException {
    return asMap(urlencoded, "UTF-8");
  }

  @SuppressWarnings("unchecked")
  public static Map<String, Object> asMap(String urlencoded, String encoding) throws UnsupportedEncodingException {

    Map<String, Object> map = new LinkedHashMap<>();

    for (String keyValue : urlencoded.trim().split("&")) {

      String[] tokens = keyValue.trim().split("=");
      String key = tokens[0];
      String value = tokens.length == 1 ? null : URLDecoder.decode(tokens[1], encoding);

      String[] keys = key.split("\\.");
      Map<String, Object> pointer = map;

      for (int i = 0; i < keys.length - 1; i++) {

        String currentKey = keys[i];
        Map<String, Object> nested = (Map<String, Object>) pointer.get(keys[i]);

        if (nested == null) {
          nested = new LinkedHashMap<>();
        }

        pointer.put(currentKey, nested);
        pointer = nested;
      }

      pointer.put(keys[keys.length - 1], value);
    }

    return map;
  }

  public static void main(String[] args) throws Exception {

    String payload = "id=7&name=Pablo Mat%C3%ADas";
    User user = convert(payload, User.class);
    System.out.println("single user   -> " + user);

    payload = "users[0].id=7&users[0].name=Pablo Mat%C3%ADas&users[1].id=42&users[1].name=Bart";
    List<User> users = convert(payload, new TypeToken<List<User>>(){}.getType());
    System.out.println("list of users -> : " + users);
  }
}

class User {

  long id;
  String name;

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}