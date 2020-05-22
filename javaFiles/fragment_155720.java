Map<String, Double> nameToMean = nameToQuaters.entrySet()
        .stream()
        .collect(Collectors.toMap(
                // the key is the same
                Map.Entry::getKey,
                // for the value of the key, you can calculate the average like so
                e -> e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble())
        );
    }