Map<String, List<Student>> map =
        listOfStudents.stream().collect(Collectors.groupingBy(Student::getName));

Optional<String> studentName =
        map.entrySet()
           .stream()
           .max(Comparator.<Map.Entry<String, List<Student>>>comparingInt(e -> e.getValue().size())
                          .thenComparingInt(e -> e.getValue().stream().mapToInt(Student::getNumberOfTimesComeToSchool).sum()))
           .map(Map.Entry::getKey);