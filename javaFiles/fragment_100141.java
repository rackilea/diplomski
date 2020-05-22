public static Unit createUnit(UnitType type) {
    if (UnitType.Special == type) {
        return new Unit(type) {
            @Override
            public int swim() {
                System.out.println("special swim");
                return 0;
            }
        };
    }
    return new Unit(UnitType.Default);
}

private UnitType type;

private Unit(UnitType type) {
    this.type = type;
    System.out.println("create unit for " + type);
}

public int swim() {
    System.out.println("default swim");
    return 0;
}

public static void main(String[] args) {
    Unit fish = Unit.createUnit(UnitType.Default);
    Unit fatFish = Unit.createUnit(UnitType.Special);
    fish.swim();
    fatFish.swim();

}