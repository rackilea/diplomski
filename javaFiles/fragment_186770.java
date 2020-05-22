public ArrayList<String> translationList() {
    List<String> returnList = new ArrayList<>(String);
    for (Entry<Integer, String> entry : testMap.entrySet()) {

                returnList.add(entry.getKey()+"="+entry.getValue());

        }
    return returnList;
}