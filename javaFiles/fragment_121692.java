HashMap<String, HashSet<String>> rules = new HashMap<String, HashSet<String>>();
    for(String key : properties.stringPropertyNames()) {
        HashSet<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(properties.getProperty(key).split(",")));
        rules.put(key, set);
    }