class AllModes {

    private final Collection<Car> cars;
    private final Collection<Boat> boats;
    private final Collection<Train> trains;
    private final Collection<Plane> plain;

    public AllModes(Supplier<Collection<?>> supplier) {
        cars = (Collection<Car>)supplier.get();
        boats = (Collection<Boat>)supplier.get();
        trains = (Collection<Train>)supplier.get();
        plain = (Collection<Plane>)supplier.get();
    }
}