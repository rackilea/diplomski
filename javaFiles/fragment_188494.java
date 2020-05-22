public class SomeOtherClass {
    // Some code
    public static void main(String[] args) {
        Rainfall rainfall = new Rainfall(); // Declare and instantiate the object
        double[] rain = rainfall.getRain(); // Retrieve the value of the attribute
        /*
          And now... how to get the max value? Here's an example
         */ 
        double maxVal = Double.NEGATIVE_INFINITY;
        for(double x : rain) {
            if(x > maxVal)
                maxVal = x;
        }
        // More code
    }
}