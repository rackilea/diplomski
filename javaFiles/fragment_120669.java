Map<String, TransactionSummary> minorSummary = transactions.stream()
        .collect(groupingBy(
                t -> t.getCategory().getMinorCategory(),
                TransactionSummary.collector()
        ));

Map<String, Map<String, TransactionSummary>> majorMinorSummary = transactions.stream()
        .collect(groupingBy(
                t -> t.getCategory().getMajorCategory(),
                groupingBy(
                        t -> t.getCategory().getMinorCategory(),
                        TransactionSummary.collector()
                )
        ));