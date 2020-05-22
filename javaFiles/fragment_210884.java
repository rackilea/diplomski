List<Map<String, Map<String, String>>> list = new ArrayList<>();

    for (Map<String, Map<String, String>> m : list) {
        // All Maps.
        for (Map.Entry<String, Map<String, String>> e : m.entrySet()) {
            // Outer key.
            String key1 = e.getKey();
            for (Map.Entry<String, String> me : e.getValue().entrySet()) {
                // Inner key.
                String key2 = me.getKey();
                // The String value.
                String value = me.getValue();
            }
        }
    }