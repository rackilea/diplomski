//we are in some for loop
for ( ... ) {
    String columnKey = "animal"; //lets say we are here in the for loop
    for ( ... ) {
        String columnValue = "cat"; //assume we are here
        HashMap<String, Integer> innerMap = map.get(columnKey);

        //increment occurence
        Integer count = innerMap.get(columnValue);
        if (count == null) {
            count = 0;
        }
        innerMap.put(columnValue, ++count);
    }
}