@Value
class Result { String needle; int words, total; }

list.sort(
    Comparator.comparing(Result::getWords).reversed().
    thenComparing(Comparator.comparing(Result::getTotal));

list.stream().map(Result::getNeedle).forEach(System.out::println);