int maxSize = 5;
IntStream.concat(IntStream.iterate(2, i -> i + 1).limit(maxSize),
                 IntStream.iterate(maxSize, i -> i - 1).limit(maxSize - 1))
         .mapToObj(count -> IntStream.range(1, count).mapToObj(c -> "b").collect(Collectors.joining()))
         .flatMap(b -> Stream.of(b, "\n"))
         .limit((maxSize * 2 - 1) * 2 - 1)
         .forEach(printWriter::print);