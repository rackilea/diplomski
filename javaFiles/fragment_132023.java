Iterator<String> myVeryOwnIterator = myMap.keySet().iterator();
    while(myVeryOwnIterator.hasNext()) {
        String key=(String)myVeryOwnIterator.next();
        String[] value= myMap.get(key);
        System.out.println(key + " " + value[0]);
    }