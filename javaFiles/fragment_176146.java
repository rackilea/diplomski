ArrayList<String> listText1 = new ArrayList<String>();
    listText1.add("A");
    listText1.add("B");
    listText1.add("C");
ArrayList<String> listText2 = new ArrayList<String>();
    listText2.add("X");
    listText2.add("Y");
    listText2.add("Z");

List<Map<String, String>> alist = new ArrayList<Map<String, String>>();
Map<String, String> map;
int count = items.size();
for(int i = 0; i < count; i++) {
    map = new HashMap<String, String>();
    map.put("txt1", listText1.get(i));
    map.put("txt2", listText2.get(i));
    alist .add(map);
}

SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.list, new String[] { "txt1", "txt2" }, new int[]{R.id.text1, R.id.text2});