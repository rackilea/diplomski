Map<Integer, HtmlTagValues> sortedMap = map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.comparing(HtmlTagValues::getTop)))
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));