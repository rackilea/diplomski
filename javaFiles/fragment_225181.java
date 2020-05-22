public enum BuildingType {
    farm(Farm.class),
    shop(Shop.class),
    house(House.class);
    private Class<? extends Building> clazz;
    private BuildingType(Class<? extends Building> clazz) {
        this.clazz = clazz;
    }

    public Building createBuilding() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(clazz + " has no default constructor");
        }
    }
}