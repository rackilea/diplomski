bumperCars
    .stream()
    .map(x -> {
        List<String> list = new ArrayList<>();
        list.add(x.getCarCode());
        return new SimpleEntry<>(x, list);
    })
    .map(x -> new DistGroup(x.getKey().getSize(), x.getKey().getColor(), x.getValue()))
    .collect(Collectors.toMap(
        Function.identity(),
        Function.identity(),
        (left, right) -> {
            left.getCarCodes().addAll(right.getCarCodes());
            return left;
        }))
    .values(); // Collection<DistGroup>