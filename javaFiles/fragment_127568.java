Map<String, Object> finalMap = new HashMap<String, Object>();

for (Map map : someObjectsList) {
    for (Object key : map.keySet()) {
        String value = ((String) map.get(key));
        finalMap.merge((String) key, value, (k, v) -> k + "," + v);
    }
}