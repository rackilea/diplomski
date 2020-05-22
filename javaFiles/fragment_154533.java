Map<String, Double> nickMap = userMap.get("Nick");
Map<String, Double> tomMap = userMap.get("Tom");

Map<String, List<Double>> commonMap = new HashMap<String, List<Double>>();

for (String movieName : nickMap.keySet()) {
    if (tomMap.containsKey(movieName)) {
        List<Double> tempList = new ArrayList<Double>();
        tempList.add(nickMap.get(movieName));
        tempList.add(tomMap.get(movieName));
        commonMap.put(movieName, tempList);
    }
}