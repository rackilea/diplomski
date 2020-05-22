car.getVersions().stream()
        .map(versionCar -> processObjects(versionCar))
        .reduce((map1, map2) -> {
                    map2.forEach((key, subset) -> map1.get(key).addAll(subset));
                    return map1;
                })
        .orElse(new HashMap<>());