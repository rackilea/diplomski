printer.printRecords(graph.rowMap().entrySet()
        .stream()
        .map(entry -> ImmutableList.builder()
                .add(entry.getKey())
                .addAll(entry.getValue().values())
                .build())
        .collect(Collectors.toList()));