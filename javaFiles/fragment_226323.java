// instantiating one additional Obj and reusing those from the question
Obj obj3a = new Obj(3, "a");

// reusing sortingComparator from the code above
Set<Obj> set = Stream.of(obja, objb, objc, objd, obj3a)
        .distinct()
        .sorted(sortingComparator)
        .collect(Collectors.toCollection(LinkedHashSet::new));

System.out.println(set); // [(3a), (1a), (2c)]