private static Optional<House> test() {
    List<House> houseList = Arrays.asList(
            new House(new Room(1), new Room(3)),
            new House(new Room(5))
    );
    int color = 5;

    return houseList.stream()
            .filter(h -> h.getRooms()
                    .stream()
                    .anyMatch(r -> r.getColor() == color))
            .findFirst();
}