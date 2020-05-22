Map<Integer, Map<String, Integer>> resultSet =
                IntStream.range(0, temporaryResult.size())
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i + 1,
                        temporaryResult.get(i)))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey,
                        AbstractMap.SimpleEntry::getValue));