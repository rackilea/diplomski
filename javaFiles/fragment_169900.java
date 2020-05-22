int maxSize = 5;
String str =
        IntStream.concat(IntStream.iterate(2, i -> i + 1).limit(maxSize),
                         IntStream.iterate(maxSize, i -> i - 1).limit(maxSize - 1))
                 .mapToObj(count -> IntStream.range(1, count).mapToObj(c -> "b").collect(Collectors.joining()))
                 .collect(Collectors.joining("\n"));

printWriter.print(str);