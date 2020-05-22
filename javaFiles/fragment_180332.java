protected Object handleGetObject(String key) {
    if (key.endsWith(".list")) {
        String listkey = key.substring(0, key.length() - 5);
        List<String> list = new ArrayList<String>();
        for (int i = 1; containsKey(listkey + i); i++) {
            list.add(String.valueOf(getObject(listkey + i)));
        }
        if (!list.isEmpty()) {
            return list;
        }
    }
    return getObject(key);
}