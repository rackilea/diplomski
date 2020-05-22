HashMap<String, ArrayList<String>> hkansDictionary = new HashMap<String, ArrayList<String>>();

    public String getValue (String key, int valueIdx) {
        ArrayList<String> valueSet = hkansDictionary.get(key);
        return valueSet.get(valueIdx);
    }