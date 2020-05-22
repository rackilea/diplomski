Map<String,Integer> unsortMap = new TreeMap<String,Integer>();

unsortMap.put("103",4);
unsortMap.put("4",4);
unsortMap.put("11101",4);
unsortMap.put("5",5);
unsortMap.put("1003",4);

Map<String, Integer> result = unsortMap.entrySet().stream()
        .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(String::length))

        ).sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));


System.out.println(result);

out => {4=4, 103=4, 1003=4, 11101=4, 5=5}