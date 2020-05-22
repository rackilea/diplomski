Map<Long, List<String>> top5 = students.stream()
        .collect(Collectors.groupingBy(Student::getName, Collectors.summingLong(Student::getMarks)))
        .entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .limit(5)
        .collect(Collectors.groupingBy(Map.Entry::getValue, LinkedHashMap::new,
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())));