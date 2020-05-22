models.stream()
        .collect(Collectors.groupingBy(model -> model.getId(), //ModelA::getId - Using method reference
                Collectors.toMap(model -> model.getName(), model -> model.getValue(), (map1, map2) -> map1)))
        .entrySet()
        .stream()
        .map(entry -> new ModelB(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());