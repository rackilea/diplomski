List<Map<String, Object>> row; 

for (Map<String, Object> map : row) {
    for (Map.Entry<String, Object> entry : map.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();
    }
}