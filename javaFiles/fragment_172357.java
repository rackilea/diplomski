package sortclient;

public class SortClient {
    private String temp;
    private String conv1;
    private String conv2;
    private Double result;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getConv1() {
        return conv1;
    }

    public void setConv1(String conv1) {
        this.conv1 = conv1;
    }

    public String getConv2() {
        return conv2;
    }

    public void setConv2(String conv2) {
        this.conv2 = conv2;
    }

    public Double getResult() {
        result = Double.parseDouble(temp);
        if (conv1.equalsIgnoreCase(conv2)) {
            return result;
        } else if (conv2.equalsIgnoreCase("Celsius")) {
            return toCelsius(result);
        } else if (conv2.equalsIgnoreCase("Fahrenheit")) {
            return toFahrenheit(result);
        }
        return 0.0;
    }

    public double toCelsius(double tempFahrenheit )
    {
        return ((5.0 / 9.0) * ( tempFahrenheit - 32 ));

    }

    public double toFahrenheit( double tempCelsius )
    {
        return (tempCelsius * 9.0 / 5.0) + 32;

    }

}