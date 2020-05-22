String query = url.getQuery();  
 Map<String, String> map = getQueryMap(query);  
 Set<String> keys = map.keySet();  
 for (String key : keys)  
 {  
    System.out.println("Name=" + key);  
    System.out.println("Value=" + map.get(key));  
 }