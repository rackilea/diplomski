List<Job> collect = jobs.stream()
    .collect(groupingBy(identity(), reducing((l, r) -> {
        l.networks().addAll(r.networks());
        return l;
    })))
    .values().stream()
    .map(Optional::get)
    .collect(toList);