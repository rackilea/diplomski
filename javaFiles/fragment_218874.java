List<CallSummary> summaries = groupedMap.entrySet().stream()
        .map(entry -> new CallSummary(entry.getKey(), entry.getValue().entrySet()
                .stream()
                .map(en -> new ItemSummary(en.getKey(), percentage(en.getValue(),
                        nameBasedCount.get(entry.getKey()))))
                .collect(Collectors.toList()))
        ).collect(Collectors.toList());