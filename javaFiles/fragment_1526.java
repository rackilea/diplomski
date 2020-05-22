Collection<Map<String, Object>> myColl = new ArrayList<Map<String,Object>>();

Map<String, Object> map1 = new HashMap<String, Object>();
map1.put("Field1","Value1");
map1.put("Field2","Value2");
map1.put("Field3", someObject);
myColl.add(map1);

JRMapCollectionDataSource source = new JRMapCollectionDataSource(myColl);