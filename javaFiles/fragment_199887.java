List<String> elemList = myMap.get(key);
if (elemList == null){
    elemList = new ArrayList<String>;
    myMap.put(key, elemList);
}
elemList.add(key);