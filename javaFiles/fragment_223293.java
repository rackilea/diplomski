class Student { String name; boolean old; boolean stupid; }

List<Student> students = initializeListOfStudents();

// alter these flags accordingly to your needs
Boolean old = null;
Boolean stupid = true;

// then do the filter
List<Student> allStupids = students.stream()
    .filter(it -> (old==null || it.old == old) && (stupid==null || it.stupid==stupid))
    .collect(Collectors.toList());