HOSTING.entrySet()
            .stream()
            .filter(map -> s.add(map.getValue()))
            .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue())).forEach((k, v) -> {
        System.out.println("show:" + v);
    });