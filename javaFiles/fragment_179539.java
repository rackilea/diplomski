public static void main(String[] args) {
    HashMap<String, Object> map = new HashMap<>();

    map.put("key1", new String[]{"a","b","c"});

    map.forEach((k,v) -> System.out.println(toList(v)));

  }

  public static List<String> toList(Object obj) {
    return Arrays.asList((String[])obj);
  }