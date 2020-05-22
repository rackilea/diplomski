return listMaps
        .stream()
        .flatMap(e -> e.entrySet()
                       .stream())
        .filter(e -> e.getValue() != null)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));