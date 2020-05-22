public static Building getBuildingByPosition(int pos) {
    Optional<Building> building = Building.Buildings
    .stream()
    .filter(x -> x.getBuildingPosition() == pos)
    .findFirst();
    return building.orElse(null);
}