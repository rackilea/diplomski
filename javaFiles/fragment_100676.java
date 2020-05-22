public void changeList(List<HashMap<String, Object>> list) {
    for (HashMap<String, Object> entry : list) {
        for (String key : entry.keySet()) {
            if ("Kids".equals(key)) {
                Object o = entry.get(key);
                changeList((List<HashMap<String, Object>>)o);
            }
            else if ("Page".equals(key)) {
                String dest = (String)entry.get(key);
                entry.put("Page", dest.replaceAll("Fit", "FitV 60"));
            }
        }
    }
}