HashMap<String, HashMap<String, String>> hkansDictionary 
              = new HashMap<String, HashMap<String, String>>();
    ----
    public String getValue (String key, String name) {
        HashMap<String, String> valueSet = hkansDictionary.get(key);
            return valueSet.get(name);
    }