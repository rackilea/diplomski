map.entrySet()
            .stream()
            .collect(Collectors.toMap(
                    Entry::getKey,
                    x -> Arrays.stream(x.getValue()).distinct().toArray()

    ));