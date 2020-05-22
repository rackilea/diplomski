List<Map<String, DTO>> result =
         content.values().stream()
                         .filter(value -> value instanceof List)
                         .map(value -> (List<Map<String, DTO>>) value)
                         .flatMap(List::stream)
                         .collect(Collectors.toList());

System.out.println(result);