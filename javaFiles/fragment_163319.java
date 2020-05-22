// Adding to a List
    list.add(myObject);         // adds to the end of the list
    map.put(myKey, myObject);   // sure, you can do this, but what is myKey?
    map.put("1", myObject);     // you could use the position as a key but why?

    // Iterating through the items
    for (Object o : myList)           // nice and easy
    for (Object o : myMap.values())   // more code and the order is not guaranteed