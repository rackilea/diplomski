Map<String, Double> standardDeviationMap =
    list.stream()
        .collect(Collectors.groupingBy(
            e -> e.getCar(),
            Collectors.mapping(
                e -> e.getHigh() - e.getLow(),
                Collector.of(
                    DoubleStatistics::new,
                    DoubleStatistics::accept,
                    DoubleStatistics::combine,
                    d -> d.getStandardDeviation()
                )
            )
        ));