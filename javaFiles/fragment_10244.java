catalogList2.stream()
    .collect(Collectors.groupingBy(Catalog::getId))
    .forEach((id, catalogs) -> {
        System.out.println("Catalog id : " + id + " : " + catalogs.size());
        catalogs.forEach(System.out::println);
    });