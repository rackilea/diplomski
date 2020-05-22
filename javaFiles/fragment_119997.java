Set<String> resultSet = 
             map.values()
                .stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .map(Request::getId)
                .collect(Collectors.toSet());