Collections.sort(carList, Ordering.explicit(preOrderedList).onResultOf(new Function<Car, String>() {
    @Override
    public String apply(Car car) {
        return car.getName();
    }
}));