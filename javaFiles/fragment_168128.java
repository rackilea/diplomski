List<Integer> result = l
        .stream()
        .flatMap(map -> map.values().stream())
        .collect(Collectors.toList());

System.out.println(result); // [1, 9, 23, 6]