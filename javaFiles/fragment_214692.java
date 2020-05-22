Map<String, Map<String, List<BigDecimal>>> result =
    pojo.stream()
        .collect(Collectors.groupingBy(
            POJO::getEnvironment,
            Collectors.groupingBy(
                POJO::getName,
                Collectors.mapping(p -> BigDecimal.valueOf(p.getThroughput()), Collectors.toList())
            )
        ));