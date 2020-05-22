IntStream.range(0, array.length)
         .mapToObj(i -> Arrays.stream(array).skip(i).limit(Math.min(3, array.length-i)).toArray())
         .map(a -> String.join("+",
                    Arrays.stream(a).mapToObj(String::valueOf).toArray(String[]::new)) + "=" +
                    Arrays.stream(a).sum())
         .forEachOrdered(System.out::println);