class Car {
    @Inject 
    Car(Provider<Seat> seatProvider) {
        Seat driver = seatProvider.get();
        Seat passenger = seatProvider.get();
        ...
    }
}