List<Integer> list = new ArrayList<>();
    List<Integer> result = Stream.of(1, 2, 3, 4)
            .peek(x -> list.add(x))
            .map(x -> x * 2)
            .collect(Collectors.toList());

    System.out.println(list);
    System.out.println(result);