List<String> collect = Stream.of(first.getSubjects())
    .map(Subject::getPublisher)
    .filter(Objects::nonNull) // filter all null publishers
    .map(Publisher::getBooks)
    .filter(Objects::nonNull) // filter all null book lists
    .flatMap(Arrays::stream)
    .map(Book::getBookId)
    .filter(Objects::nonNull) // filter all null book ids
    .collect(Collectors.toList());