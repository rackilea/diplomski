int longest = runs.stream()
        .mapToInt(list -> list.size())
        .max()
        .getAsInt();
    runs.stream()
        .filter(list -> list.size() == longest)
        .forEach(System.out::println);