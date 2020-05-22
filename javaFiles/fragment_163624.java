List<MyClass> result = list.stream().collect(
    Collectors.groupingBy(
        MyClass::getHostName,
        Collectors.toCollection(
            () -> new TreeSet<>((a, b) -> a.getLastSeen().compareTo(b.getLastSeen()))
        )
    )
).values().stream().map(TreeSet::last).collect(Collectors.toList());