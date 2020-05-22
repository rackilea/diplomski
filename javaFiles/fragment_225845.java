Map<String, Map<String,Double>>
output = input.entrySet()
              .stream()
              .collect(Collectors.toMap(e -> e.getKey(),
                                        e -> Collections.singletonMap (
                                            "1/1/1800",
                                            e.getValue()
                                             .values()
                                             .stream()
                                             .filter (d->!Double.isNaN (d))
                                             .mapToDouble (Double::doubleValue)
                                             .max()
                                             .orElse(0.0))));