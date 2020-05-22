// this is comparator that sorte `Student` accorgind to their `adminDate` ascending order
Comparator<Student> sortByAdminDateAsc = Comparator.comparingInt(one -> Integer.parseInt(one.adminDate));

// Use `TreeMap` with given comparator
Map<Student, List<Subject>> studentSubjects = new TreeMap<>(sortByAdminDateAsc);
// fill the map

studentSubjects.forEach((student, subjects) -> {
    // student are sorted according to comparator
});