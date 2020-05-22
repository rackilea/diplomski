StringBuffer sb = new StringBuffer();
try {
  BufferedReader reader = request.getReader();
  String line;
  Gson gson = new Gson();
  while ((line = reader.readLine()) != null) {
    Map map = gson.fromJson(line, Map.class);
    for(Object value : map.values()) {
      System.out.println(value);
    }
    sb.append(line);
    System.out.println(line);
  }
} catch (Exception e) {
  e.printStackTrace();
}