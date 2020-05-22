public int availableCars(Class<? extends Car> carType) {
    int count = 0;
    for (Car car : fleet) {
        if (carType.isInstance(car)) {
            count++;
        }
    }
    return count;
}