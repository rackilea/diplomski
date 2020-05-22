Map<String, TreeMap<LocalDate, Thing>> result = Arrays
            .asList(new Thing("a", LocalDate.now().minusDays(1), 12f), new Thing("a", LocalDate.now(), 12f), new Thing("a", LocalDate.now(), 13f))
            .stream()
            .collect(Collectors.groupingBy(Thing::getKey,
                    Collectors.toMap(Thing::getActivityDate, Function.identity(),
                            (Thing left, Thing right) -> new Thing(left.getKey(), left.getActivityDate(), left.getValue() + right.getValue()),
                            TreeMap::new)));


 System.out.println(result); // {a={2017-06-24= value = 12.0, 2017-06-25= value = 25.0}}