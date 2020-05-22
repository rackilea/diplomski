public class Names extends RealmObject {

  ...

  public static Names fromJson(JSONObject json) {
    Names names = new Names();
    names.setShortField(json.getString("short");
    return names;
  }
}