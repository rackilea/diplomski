Map<String, Map<String, Integer>> answerCountsByField =
    dtos.flatMap(dto -> dto.getData().entrySet().stream()).collect(
        Collectors.groupingBy(e -> e.getKey(),
            Collectors.groupingBy(e -> e.getValue(),
                Collectors.collectingAndThen(
                        Collectors.counting(), Long::intValue))));