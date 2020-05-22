List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
List<Integer> filteredList = list.stream()
        .filter(i -> i % 2 == 0)
        .filter(i -> i != 0)
        .collect(Collectors.toList());
System.out.println(filteredList);