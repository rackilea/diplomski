LinkedHashMap<String, Long> countByWordSorted = collect.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (v1, v2) -> {
                        throw new IllegalStateException();
                    },
                    LinkedHashMap::new
            ));