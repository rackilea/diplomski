public class Rainfall {
    private double[] rain;
    /*
      It is a good idea to make the attributes private, and then access them
      through methods (getters to get the values, setters to change the values)
    */
    // more attributes  here
    public Rainfall(double[] rain) {
        this.rain = rain; // THIS IS THE WAY how you initialize an attribute
    }
    public double getRain() {
        /*
           Remember what I said about getters? This is an example
         */
        return rain;
    }
    public void setRain(double[] rain) {
        /*
           Remember what I said about setters? This is an example
         */
        this.rain = rain;
    }
    // More code...
}