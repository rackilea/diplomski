List<MyObject> firstList = getArrayListFromSQLiteDb(criteria);
List<MyObject> secondList = new ArrayList<>();

for(MyObject obj : firstList) {
    secondList.add(obj.clone());
}