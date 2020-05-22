List<Student> listOfStudents = getStudents();
List<Student> outputStudents =
    listOfStudents
        .stream()
        .flatMap(student -> {
            List<String> classes = student.getClasses();
            if (classes.isEmpty()) return ImmutableList.of(student).stream();
            return classes.stream().map(clazz -> new Student(student.getName(), student.getClassName(), ImmutableList.of(clazz)));
        })
        .collect(Collectors.toList());