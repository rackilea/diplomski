public void process(List<Detail> details) throws Exception {

    Map<String, List<Detail>> byCode =
        details.stream().collect(Collectors.groupingBy(Detail::getCode));

    byCode.entrySet().stream().forEach(entry -> {
        System.out.println(headerFromType(entry.getKey()));
        entry.getValue().foreach(System.out::println);
        System.out.println(tailFromType(entry.getKey()));
}