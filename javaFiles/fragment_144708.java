public class Currency {

    private final double exchangeRate ;
    private final String name ;

    public Currency(String name, double exchangeRate) {
        this.name = name ;
        this.exchangeRate = exchangeRate ;
    }

    public double convert(double value) {
        return value * exchangeRate ;
    }

    public String getName() {
        return name ;
    }

    @Override
    public String toString() {
        return getName();
    }
}