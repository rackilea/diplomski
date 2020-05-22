Map<Object, Double> scoreMap = Arrays.stream(scores)
        .collect(
            Collectors.groupingBy(i -> i[0], 
            Collectors.averagingInt(i -> Integer.parseInt(i[1])
        )));

String winner = scoreMap.entrySet().stream()
    .max(Comparator.comparingDouble(e -> e.getValue()))
    .get().getKey().toString();