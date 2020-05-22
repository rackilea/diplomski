Map<String, Set<String>> givenMap = new HashMap<String, Set<String>>();
    Map<String, List<String>> newMap = new HashMap<String, List<String>>();

    Set<String> newSet = new HashSet<String>();
    newSet.add("rohit");

    givenMap.put("a", newSet);
    givenMap.put("b", newSet);
    givenMap.put("c", newSet);

    for (String str: givenMap.keySet()) {
        newMap.put(str, new ArrayList<String>(givenMap.get(str)));
    }

    for(String str:newMap.keySet()) {
        System.out.println(newMap.get(str));
    }