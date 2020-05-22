@Builder
public static class Car {

    // kickstart builder method available to user
    public static CarBuilder builder(String brand, String model) {
        return builder().brand(brand).model(model);
    }

    // hide lombok's own builder method and apply some defaults:
    private static CarBuilder builder() {
        return new CarBuilder().color(System.getenv("DEFAULT_CAR_COLOR"));
    }

}