List<Map<String , Object>> myMap  = new ArrayList<Map<String,Object>>();

// create a fresh map
Map<String,Object> subSourceMap1 = new HashMap<>();
subSourceMap1.put("name", "bobby");
subSourceMap1.put("address", "xxx.xxxx@xxx.co.id");

// create a fresh map
Map<String,Object> subSourceMap2 = new HashMap<>();
subSourceMap2.put("name", "2sadasd");
subSourceMap2.put("address", "xxx.xxxx@xxx.co.id");      

// create a fresh map
Map<String,Object> subSourceMap3 = new HashMap<>();
subSourceMap3.put("name", "ggfgf");
subSourceMap3.put("address", "xxx.xxxx@xxx.co.id");      

// note that you do not need to specify the index here, just use
// add with 1 parameter which will append to the end of the list
myMap.add(subSourceMap1);
myMap.add(subSourceMap2);
myMap.add(subSourceMap3);