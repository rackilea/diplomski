List<StudentB> bList =
    aList.stream() // Stream<StudentA>
         .collect(Collectors.groupingBy(StudentA::getName)) // Map<String,List<StudentA>>
         .values() // Collection<List<StudentA>>
         .stream() // Stream<List<StudentA>>
         .map(list -> {
             StudentB b = new StudentB();
             b.setName(list.get(0).getName());
             b.setAge(list.get(0).getAge());
             list.forEach(a -> b.addSubject(new Subject(a.getSubjectID(),a.getSubjectName())));
             return b;
         }) // Stream<StudentB>
         .collect(Collectors.toList());