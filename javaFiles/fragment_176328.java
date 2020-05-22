public static void hashMapper(Map<String, Object> lhm1) throws ParseException {
    for (Map.Entry<String, Object> entry : lhm1.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof String) {
             System.out.println(value);
        } else if (value instanceof Map) {
            Map<String, Object> subMap = (Map<String, Object>)value;
            hashMapper(subMap);
        } else {
             throw new IllegalArgumentException(String.valueOf(value));
        }

    }
}