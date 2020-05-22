Date curretMonthDate = getCurrentMonthDate();
Map<String, Set<String>> sortedNames = dataMap.entrySet().stream()
.map(e -> new AbstractMap.SimpleEntry<String, LinkedHashSet<String>>(e.getKey(),
                    e.getValue()
                    .entrySet()
                    .stream()
                    .filter(inner -> inner.getKey().equals(curretMonthDate))
                    .flatMap(subEntry -> subEntry
                                .getValue()
                                .entrySet()
                                .stream()
                                .map(Entry::getKey))
        .collect(Collectors.toCollection(LinkedHashSet<String>::new))))
.collect(Collectors.toMap(Entry::getKey, Entry::getValue));