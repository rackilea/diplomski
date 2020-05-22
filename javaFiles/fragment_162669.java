Student student = ?
List<Student> output = 
    student
        .getClasses()
        .stream()
        .map(clazz -> new Student(student.getName, student.getClassName, clazz))
        .collect(Collectors.toList());