class Car {
    <C extends Car> Optional<C> as(Class<C> type) {
        return type.isInstance(this)
                ? Optional.of(type.cast(this))
                : Optional.empty();
    }
}

Car car = new Convertible();

car.as(Convertible.class).ifPresent(convertible -> {
    convertible.unfoldRoof();
});