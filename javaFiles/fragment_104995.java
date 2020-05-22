class Cars<CAR> {
    private List<CAR> cars = new ArrayList<CAR>();

    // ...

    public Iterable<String> getColors() {
       return Iterables.transform(cars, getCarToColorTransform());
    }

    // Expose other methods of List<CAR>, but ONLY the ones you need.
}