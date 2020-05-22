// Iterating over the String
        for (int i = 0; i < characters.length(); i++) {
            // Taking particular character in the Iteration
            str = "" + characters.charAt(i);
            // Checking value of a particular character in the map

            /*
             * if (map.get(str) == null) {
             * 
             * // If not present in map, then add that to the map and list map.put(str, 1);
             * list.add(str); }
             * 
             * else {
             * 
             * index = map.get(str); map.replace(str, index + 1); }
             */
            // If not present in map, then add that to the map and list map.put(str, 1);
            if (map.get(str) == null) {
                //map.put(str, index++);
                map.put(str, map.size());
                list.add(str);
            }
        }

    // Below is just for testing what has been put to the collections ... 
    Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
    while (it.hasNext()) {
        Entry<String, Integer> e = it.next();
        System.out.println(e.getKey() + " ; " + e.getValue());
    }

    for (String a: list) {
        System.out.println(a);
    }