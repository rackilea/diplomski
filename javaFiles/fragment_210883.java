ArrayList<HashMap<String, HashMap<String, String>>> list = new ArrayList<>();

    for (HashMap<String, HashMap<String, String>> m : list) {
        for (Map.Entry<String, HashMap<String, String>> e : m.entrySet()) {
            String key1 = e.getKey();
            for (Map.Entry<String, String> me : e.getValue().entrySet()) {
                String key2 = me.getKey();
                String value = me.getValue();
            }
        }
    }