assert  IntStream.range(0, str.length())
                .filter(n -> n % 2 != 0)
                .map(str::charAt)
                .map(x -> x  / 5)
                .sum()
                ==
        IntStream.range(0, str.length())
                .filter(n -> n % 2 != 0)
                .map(str::charAt)
                .reduce(0, (result, next) -> result + next / 5);