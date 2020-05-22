Map<String, List<String>> map = new HashMap<String, List<String>>();
String key="#";

for(String value : cellValues){
    if(value.length()<=9){
         // its a key
         key = value;  
         map.put(key, new ArrayList<String>());
    }else{
        // its a list value
        map.get(key).add(value);
    }
}