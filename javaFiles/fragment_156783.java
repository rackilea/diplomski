enum VehicleType {
    CAR("car", Car.class),
    TRUCK("truck", Truck.class);

    private static Map<String, VehicleType> types = new HashMap<>();

    static {
        types.put(CAR.asString(), CAR);
        types.put(TRUCK.asString(), TRUCK);
    }

    private String str;
    private Class<? extends Vehicle> clazz;

    VehicleType(String str, Class<? extends Vehicle> clazz) {
        this.str = str;
        this.clazz = clazz;
    }

    static VehicleType of(String str) {
        return types.get(str);
    }

    @SuppressWarnings("unchecked")
    <T extends Vehicle> T createInstance() {
        try {
            return (T) this.clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // there's no default constructor.
            return null;
        }
    }

    String asString() {
        return this.str;
    }
}