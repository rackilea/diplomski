// initialization which you will have to do once somewhere in your code
List<String> ordering = Arrays.asList("OPENED", "CLICKED", "HARDBOUNCED", "BOUNCED");
Map<String, Integer> priorityMap = IntStream.range(0, ordering.size()).boxed()
        .collect(Collectors.toMap(ordering::get, i -> i));

// example input
List<Foo> myList = Arrays.asList(
        new Foo("100", "BOUNCED"), new Foo("100", "OPENED"),
        new Foo("101", "BOUNCED"), new Foo("101", "HARDBOUNCED"), new Foo("101", "BOUNCED"));

// determine foo objects that should be persisted 
Collection<Foo> toBePersisted = myList.stream()
        .filter(t -> priorityMap.containsKey(t.getStatus()))
        .collect(Collectors.toMap(Foo::getMailId, t -> t,
                BinaryOperator.minBy(Comparator.comparing(t -> priorityMap.get(t.getStatus())))))
        .values();