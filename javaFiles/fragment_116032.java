/** @return a collection of eight nearest coordinates near origin */
Collection<Coordinate> getNearCoordinates(Coordinate origin) {
    Collection<Coordinate> neighbours = new ArrayList<>();

    for (Coordinate direction : coordinates)
        neighbours.add(origin.move(direction));

    return neighbours;
}