private Map<Long, Map<String, List<String>>> objectListToMap(List<Object[]> list) {

        List<Object[]> objList = new ArrayList<>();
        Map<Long, Map<String, List<String>>> hmap = new LinkedHashMap<>();
        Map<Long, List<Object[]>> tempmap = new LinkedHashMap<>();

        for (Object[] object : list) {
            if (!hmap.containsKey(Long.parseLong(object[0].toString()))) {
                hmap.put(Long.parseLong(object[0].toString()), new HashMap<String, List<String>>());
                tempmap.put(Long.parseLong(object[0].toString()), objList);
            }
            tempmap.get(Long.parseLong(object[0].toString())).add(object);
        }

        for (Map.Entry<Long, List<Object[]>> entry : tempmap.entrySet()) {
            Map<String, List<String>> innerMap = new LinkedHashMap<>();
            for (Object[] obj : entry.getValue()) {
                if (!innerMap.containsKey(obj[1].toString())) {
                    innerMap.put(obj[1].toString(), new ArrayList<String>());
                }
                innerMap.get(obj[1].toString()).add(obj[2].toString());
            }
            hmap.get(entry.getKey()).putAll(innerMap);
        }

        return hmap;
    }