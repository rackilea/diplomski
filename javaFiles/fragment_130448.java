Map<LocalDate, Statistics> collect = prices.stream()
        .collect(Collectors.toMap(m -> m.getUpdateDate()
        .toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate(),
                 p -> new Statistics(p.getAvgPrice().doubleValue(),
                        p.getMaxPrice().doubleValue(),
                        p.getMinPrice().doubleValue())
        ));