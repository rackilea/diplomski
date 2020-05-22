public static void main(String[] args) {
    // TODO Auto-generated method stub
    Map map = new LinkedHashMap();
    JSONArray jArray = new JSONArray();


    map.put("id", "aaaaaa");
    map.put("packno", "bbbbb");
    map.put("photocover", "cccccc");
    map.put("photoback", "ddddd");
    map.put("evidi", "eeeeee");
    map.put("type", "ffffff");


    jArray.add(map);
    System.out.println(jArray.toString());

}