public NewClass1() {
    // have an instance from the class that gives you the map
    ClassThatBuildsTheMap mapClass = new ClassThatBuildsTheMap();
    // get the map.  must provide id and date
    Map <String, Object> myMap = mapClass.getListInsideMapObject(id, date);
    // access the lists inside the map
    useListInsideAMap(myMap);
}

private void useListInsideAMap(Map<String, Object> map){
    // Prior to Java8:
    for (Map.Entry<String, Object> entry : map.entrySet()) {
        String key = entry.getKey(); // if you want to use the key
        Object value = entry.getValue();
        if(value instanceof List){
            // I supose it is a list of sytrings
            List l = (List) value;
            for (Object item : l) {
                // Do something with the item from the list
            }
        }
    }

    // Java8:
    // loop through the map
    map.forEach((String key, Object value)->{
        // if you want to use key, just call key

        // checks if the value (Object) from the map is a list
        if(value instanceof List){
            List l = (List)value;
            // loop through the list
            l.forEach((Object item)->{
                // Do something with the item from the list
            });
        }
    });
}