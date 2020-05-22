List<CDREvent> events =
    lines
        .map(s -> s.split(";"))
        .filter(a -> a.length == 32)
        .map(a -> new CDREvent(a[0], a[1], a[6], a[13]))
        .collect(Collectors.toList());