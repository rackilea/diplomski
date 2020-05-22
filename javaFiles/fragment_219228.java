final Map<String, List<Entry>> sortedMap =
        data.getEntries().stream()
        .sorted(Comparator.comparing(e -> ((Entry) e).getProduct().getCategories().stream().findFirst().get().getName())
               .thenComparing(Comparator.comparing(e -> ((Entry) e).getProduct().getName())) )
        .collect(Collectors.groupingBy(e -> e.getProduct().getCategories().stream().findFirst().get().getName(),
                 LinkedHashMap::new, Collectors.toList()));