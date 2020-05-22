Set<Integer> value = new HashSet<>();

        String key1 = Integer.toString(d1).concat(Integer.toString(d2));
        String key2 = Integer.toString(d2).concat(Integer.toString(d1));


        toCopy.put(key1,value);
        toCopy.put(key2,value);