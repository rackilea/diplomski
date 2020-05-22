List<List<Double>> result =
    list.parallelStream()
        .map(l -> {
                double limit = Collections.max(l)-5;
                return l.parallelStream()
                        .filter(d -> limit < d)
                        .collect(Collectors.toCollection(LinkedList::new));
            })
        .collect(Collectors.toCollection(LinkedList::new));