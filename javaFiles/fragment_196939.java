List<List<String>> result = new ArrayList<>();
for (int i=0; i<outerList.size(); i+=2) {
    List<String> priceList = outerList.get(i);
    List<String> durationsList = outerList.get(i+1);
    for (int j=0; j<priceList.size(); j++) {
        List<String> newEntry = new ArrayList<>();
        newEntry.add(priceList.get(j));
        newEntry.add(durationsList.get(j));
        result.add(newEntry);
    }
}