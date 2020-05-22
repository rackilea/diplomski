public class Temperature {
    public enum ScaleName {celsius, fahrenheit, kelvin, rankine};

    private double number;
    private ScaleName scale;

    public Temperature() {
        number = 0.0;
        scale = ScaleName.fahrenheit;
    }
    ...
}