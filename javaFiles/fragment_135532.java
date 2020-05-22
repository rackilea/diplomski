Optional<String> studentName =
    listOfStudents.stream()
                  .collect(collectingAndThen(groupingBy(Student::getName),
                                                        m -> m.entrySet()
                                                              .stream()
                                                              .max(Comparator.<Map.Entry<String, List<Student>>>comparingInt(e -> e.getValue().size())
                                                                             .thenComparingInt(e -> e.getValue().stream().mapToInt(Student::getNumberOfTimesComeToSchool).sum()))
                                                              .map(Map.Entry::getKey)));