List<Map<String,String>> list_str=new ArrayList<Map<String,String>>();
Map<String,String> map_str=new HashMap<String,String>();

map_str.put("Name", "rrrrr");
map_str.put("Age", "23");
list_str.add(map_str);
System.out.println(list_str);

map_str = new HashMap<String,String>();

map_str.put("Name", "aaaa");
map_str.put("Age", "32");
list_str.add(map_str);
System.out.println(list_str);