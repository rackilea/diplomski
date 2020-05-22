Map<String, List<String>> map = new HashMap<>();
    for (String str : lst) {
        String[] splt = str.split("\\.");
        if (!map.containsKey(splt[0])) {
            map.put(splt[0], new ArrayList<>());
        }
        map.get(splt[0]).add(str);
    }