public static Map<String,ArrayList<Object>> M = new LinkedHashMap<String,ArrayList<Object>>();

for(Map.Entry<String,ArrayList<Object>> entry : M.entrySet()){
    for(Object obj:entry.getValue()){ 
       ....
    }
}