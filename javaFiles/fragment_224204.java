public class CO2 {
    private double gallons;

    public CO2() {
        gallons = 1288.0;
    }

    public double getGallons() {
        return gallons;
    }

    public double getTons() {
        return gallons * 8.78e-3;
    }
}