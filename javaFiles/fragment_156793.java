List<String> endings= Arrays.asList("AAA", "BBB", "CCC", "DDD");
    List<String> fullList= Arrays.asList("111.AAA", "222.AAA", "111.BBB", "222.BBB", "111.CCC", "222.CCC", "111.DDD", "222.DDD", "111.EEE");
    Function<String,String> suffix = s -> endings.stream()
                                                 .filter(e -> s.endsWith(e))
                                                 .findFirst().orElse("UnknownSuffix");
    Map<String,List<String>> grouped = fullList.stream()
                                               .collect(Collectors.groupingBy(suffix));
    System.out.println(grouped);