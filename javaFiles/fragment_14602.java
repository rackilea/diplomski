private static Map<String, Object> transform(Map<String, Object> initial) {
    Map<String, Object> transformed = new HashMap<>();
    transformed.put("OPERATION_NAME", (String) initial.get("OPERATION_NAME"));
    transformed.put("READY", 0);
    transformed.put("NEW", 0);
    transformed.put("DONE", 0);
    transformed.put((String) initial.get("OPERATION_STATUS"),
                    Integer.valueOf((String) initial.get("COUNT(1)")));
    return transformed;
}

private static Map<String, Object> mergeMaps(Map<String, Object> left, Map<String, Object> right) {
    for (Entry<String, Object> re : right.entrySet()) {
        if (!"OPERATION_NAME".equals(re.getKey())) {
            left.merge(re.getKey(), re.getValue(), (l, r) -> {
                Integer res = 0;
                res += (Integer) l;
                res += (Integer) r;
                return res;
            });
        }
    }
    return left;
}