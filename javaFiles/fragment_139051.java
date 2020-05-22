public static Map buildMap(Map map){
    ...
    Set<Map.Entry<String, Object>> entryset = map.entrySet();
    for (Map.Entry<String, Object> entry : entryset) {
        String key = entry.getKey();
        Object val = entry.getValue();
        if(key.contains("_")){
            String mapName = key.substring(0, key.indexOf("_"));
            String mapKey = key.substring(key.indexOf("_")+1, key.length());
            Object mapValue = val;
            ...