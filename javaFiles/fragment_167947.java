class Temp {
    private final BigDecimal temp;
    public Temp(BigDecimal temp) {
        this.temp = temp;
    }
    public void apply(TemperatureObserver observer) {
        observer.react(this.temp);
    }
}

Temp tempObj = new Temp(temp);

observers.forEach(tempObj::apply);