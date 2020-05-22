ArrayList<String> list = new ArrayList<String>();
list.add("2015-01-13 09:30:00");
list.add("2015-01-12 05:45:10");
list.add("2015-01-13 06:22:12");
list.add("2015-01-12 01:52:40");
list.add("2015-01-12 02:23:45");    

map.put("2015-01-12", (List<String>)list.clone());
map.put("2015-01-13", (List<String>)list.clone());