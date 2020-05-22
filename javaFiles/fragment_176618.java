Map<Book, Set<Student>> result = students.parallelStream()
        .flatMap(student -> student.getBooks()
                                .parallelStream()
                                .map(book -> new Tuple(book, student)))
        .collect(Collectors.groupingBy(tuple -> tuple.book,
                Collectors.mapping(tuple -> tuple.student, Collectors.toSet())));