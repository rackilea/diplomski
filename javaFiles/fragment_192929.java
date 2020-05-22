final Map<String, Object> clubPlayerMap = 
    Arrays.stream(pairs)
          .collect(Collectors.toMap(c -> c[0].toString(), 
                                    c -> c[1], 
                                    (o1, o2) -> o1, 
                                    () -> new TreeMap<>(Collator.getInstance(new Locale("pl", "PL")))));