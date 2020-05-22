interface Car<T extends Car> {
    T getCar();
}

class MazdaRX8 implements Car<MazdaRX8 > {
    public MazdaRX8 getCar() {
        return this;
    }
}