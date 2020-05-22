Map<String, List<Integer>> result =
        outerMap.entrySet()
                .stream()
                .flatMap(e -> e.getValue().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

System.out.println(result); // prints {third=[5, 6], forth=[7, 8], first=[1, 2], second=[3, 4]}