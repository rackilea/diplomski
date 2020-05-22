for (Entry<String, Object> entry : map.entrySet()) {
    if (entry.getValue() instanceof Map) {
        Map innermap = (Map) entry.getValue();
        System.out.println(innermap.get("GCO"));
    }
}