List<Map<String, String>> list = new ArrayList<Map<String, String>>();

for (int j = 0; j < typeList.size(); j++) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("type", typeList.get(j));
    list.add(map);
}