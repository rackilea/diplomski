public enum TempScale {
    CELSIUS("Celsius", 1.0, -273.15), 
    FAHRENHEIT("Fahrenheit", 5.0 / 9.0, -459.67), 
    KELVIN("Kelvin", 1.0, 0.0);

    private TempScale(String name, double ratioToKelvin, double absZero) {
        this.name = name;
        this.ratioToKelvin = ratioToKelvin;
        this.absZero = absZero;
    }

    private String name;
    private double ratioToKelvin;
    private double absZero;

    public String getName() {
        return name;
    }

    public double getRatioToKelvin() {
        return ratioToKelvin;
    }

    public double getAbsZero() {
        return absZero;
    }

    public double convertToKelvin(double value) {
        return (value - absZero) * ratioToKelvin;
    }

    public double convertFromKelvin(double kelvinValue) {
        return (kelvinValue / ratioToKelvin) + absZero;
    }

}