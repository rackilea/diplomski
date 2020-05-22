String data =
        "[Category 1]\n" +
        "1 2 3 4\n" +
        "5 6 7 8\n" +
        "\n" +
        "[Category 2]\n" +
        "9 8 7 6\n" +
        "5 4 3 2\n" +
        "\n" +
        "[Category 3]\n" +
        "1 3 7 6\n" +
        "4 4 3 2\n";

Stream.of(data.split("\\R"))  // form Java 8 regex engine supports \R as line separator
      .dropWhile(line->!line.equals("[Category 2]"))
      .takeWhile(Predicate.not(String::isEmpty))
      .forEach(System.out::println);