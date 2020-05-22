Map<String, Map<String, Integer>> mapOfMap = new HashMap<String, Map<String, Integer>>();

    //Make one of these for every first key
    Map<String, Integer> mapOfInt = new HashMap<String, Integer>(); 

    mapOfInt.put(null, 1); 
    mapOfInt.put("Z", 2); 

    mapOfMap.put("A", mapOfInt);


    System.out.println(mapOfMap.get("A").get(null));
    System.out.println(mapOfMap.get("A").get("Z"));