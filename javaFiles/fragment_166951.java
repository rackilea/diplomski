public static void main(String[] args) throws IOException {
    createJson();
}

public static List<Map<String, String>> getMapList(ResultSet rs) throws SQLException {
    List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();

    while(rs.next()) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("1", rs.getString("col1"));
        map.put("2", rs.getString("col2"));
        map.put("OUTLET", rs.getString("outlet"));
        map.put("BILLDATE", rs.getString("billdate"));
        map.put("TOTAL", rs.getString("total"));
        mapList.add(map);
    }
    return mapList;
}

public static void createJson() {
    List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();

    Map<String, String> map1 = new LinkedHashMap<String, String>();
    map1.put("1", "50");
    map1.put("2", "55");
    map1.put("OUTLET", "ol2");
    map1.put("BILLDATE", "08-22-18");
    map1.put("TOTAL", "105");

    Map<String, String> map2 = new LinkedHashMap<String, String>();
    map2.put("1", "60");
    map2.put("2", "65");
    map2.put("OUTLET", "ol3");
    map2.put("BILLDATE", "08-23-18");
    map2.put("TOTAL", "125");

    mapList.add(map1);
    mapList.add(map2);

    String json = new Gson().toJson(mapList);
    System.out.println(json);
}