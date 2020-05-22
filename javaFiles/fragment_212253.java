int[] numbers = new int[10];
IntStream.range(0, 100).forEach( //
        x -> numbers[(int) (Math.random() * numbers.length)]++);
IntStream.range(0, numbers.length) //
        .forEachOrdered(x -> System.out.printf( //
                "%d was generated %d times.%n", x, numbers[x]));