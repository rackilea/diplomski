public static String toJson(List<Pojo> pojos) {
      Gson gson = new Gson();
      Map m = new TreeMap();
      m.put("pojos", pojos);
      return gson.toJson(m);
  }