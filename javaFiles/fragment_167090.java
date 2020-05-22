public Object getIgnoreCase(JSONObject jobj, String key) {

    Iterator<String> iter = jobj.keySet().iterator();
    while (iter.hasNext()) {
        String key1 = iter.next();
        if (key1.equalsIgnoreCase(key)) {
            return jobj.get(key1);
        }
    }

    return null;

}