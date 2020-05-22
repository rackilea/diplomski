//Declared with the other variables
HashMap<String, List<Double>> sortedMap = new HashMap<String, List<Double>>();

//Added after the while loop
for (String key : mvMap.keySet()) {
    List<Double> list = new ArrayList<Double>(mvMap.get(key));
    Collections.sort(list);
    sortedMap.put(key, list);
}