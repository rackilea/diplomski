Set<Integer> value1 = new HashSet<>();
        String key1 = Integer.toString(d1).concat(Integer.toString(d2));
        toCopy.put(key1,value1);
        Set<Integer> value2 = new HashSet<>();
        String key2 = Integer.toString(d2).concat(Integer.toString(d1));
        toCopy.put(key2,value2);