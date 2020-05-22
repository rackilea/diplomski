Stream.of(first.getSubjects())
    .map(Subject::getPublisher)
    .map(Publisher::getBooks)
    .flatMap(Arrays::stream)
    .map(Book::getBookId)
    .collect(Collectors.toList());