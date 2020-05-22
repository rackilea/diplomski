Comparator<List<Summary>> valueComparator;

LinkedHashMap<String, List<Summary>> mapSorted = mostMentionsMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(valueComparator))
        .collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, // or throw here (just in case)
                LinkedHashMap::new
        ));