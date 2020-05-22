public static void main(String[] args) {
    Map<String, Integer> dates = new HashMap<String, Integer>();
    dates.put("2015-07-14", 40);
    dates.put("2015-07-15", 8);
    dates.put("2015-07-16", 0);
    dates.put("2015-07-17", 0);
    dates.put("2015-07-18", 0);
    dates.put("2015-08-01", 1);
    dates.put("2015-08-02", 1);
    dates.put("2015-08-03", 2);
    dates.put("2015-08-04", 1);

    Map<String, Integer> result = new HashMap<String, Integer>();

    for (Entry<String, Integer> entry  : dates.entrySet()) {
        String key = entry.getKey().split("-")[0] + "/" + entry.getKey().split("-")[1];
        Integer value = entry.getValue();
        Integer oldValue = result.get(key) != null ? result.get(key) : 0;
        result.put(key, oldValue + value);
    }

    for (Entry<String, Integer> entry  : result.entrySet()) {
        System.out.println("Month " + entry.getKey() + "- Value = " + entry.getValue());
    }

}