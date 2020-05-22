long howMany = Stream.of(1, 2, 3, 4)
            .peek(x -> list.add(x))
            .count();

    System.out.println(list);
    System.out.println(howMany);