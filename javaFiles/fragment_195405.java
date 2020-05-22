output = input.stream()
              .flatMap(List::stream)
              .collect(Collectors.groupingBy(map -> map.get("group"),
                 Collectors.mapping(
                     map -> Collections.singletonMap("value", map.get("value")), 
                      Collectors.toList())));