private final IntegerProperty nbPlacesReserve = new SimpleIntegerProperty();

public IntegerProperty nbPlacesReserveProperty() {
    retrun nbPlacesReserve;
}

public int getNbPlacesReserve() {
    return nbPlacesReserve.get();
}

public void setNbPlacesReserve(int value) {
    nbPlacesReserve.set(value);
}