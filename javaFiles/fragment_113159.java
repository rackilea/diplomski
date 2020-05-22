Map<String,List<String>> groups =
    nameNum.entrySet()
           .stream()
           .filter(entry -> entry.getKey().contains("Group"))
           .collect(Collectors.groupingBy(entry -> entry.getKey().substring(0, entry.getKey().lastIndexOf("_")),                     
                                          LinkedHashMap::new, 
                                          Collectors.mapping(Map.Entry::getValue,
                                                             Collectors.toList()));