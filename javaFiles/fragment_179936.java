private static void addToMap(Integer x, Integer y, Map<Integer, List<Integer>> xMap) {
        if (xMap.containsKey(x)) {
            xMap.get(x).add(y);
        } else {
            List<Integer> yList = new ArrayList<Integer>();
            yList.add(y);
            xMap.put(x, yList);
        }
    }