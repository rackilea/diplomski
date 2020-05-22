int res = IntStream.rangeClosed(1, 26)
            .filter(it -> countIfPrime(it))
            .peek(every(5, System.out::println))
            .reduce(0, (left, right) -> right);

    System.out.println("Final " + res);