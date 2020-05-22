Map<LocalDate, Statistics> collect = prices.stream()
            .collect(Collectors.toMap(
                    m -> this.convertToLocalDateViaInstant(m.getUpdateDate()),
                    p -> new Statistics(p.getAvgPrice().doubleValue(),
                            p.getMaxPrice().doubleValue(),
                            p.getMinPrice().doubleValue())
            ));