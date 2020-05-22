Map map = new HashMap<String, String>();
map.put("name1","somevalue");
map.put("name2",null);

for(String s : map.keySet()){ 
    String value = map.get(s);
        if ( s == null){
            map.remove(s);
        }
}