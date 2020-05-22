return listMaps
         .stream()
         .flatMap(e -> e.entrySet()
                        .stream())
         .filter(e -> e.getValue() != null)
         .collect(Collectors.groupingBy(Map.Entry::getKey, 
               Collectors.mapping(Map.Entry::getValue, Collectors.toList())));