List<Worker> workers;
...
List<Workers> sorted =
  workers.stream()
    .sorted(
      Comparator.comparing(Worker::getBirthDate)
        .thenComparing(Worker::getName))
    .collect(Collectors.toList());