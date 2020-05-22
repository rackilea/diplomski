Iterator<String> myVeryOwnIterator = mHashMap.keySet().iterator();
    while(myVeryOwnIterator.hasNext()) {
        String key=(String)myVeryOwnIterator.next();
        int value= mHashMap.get(key);
        System.out.println(key + " " + value);
    }