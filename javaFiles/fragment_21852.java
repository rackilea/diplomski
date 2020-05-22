public class Implementation 
{
    public static void main(String[] args)
    {        
        double degree=0;
        String celsius=null;
        String fahrenheit;
        int n;
        String[] days = {"Very Cold", "Cold", "Mild", "Very Mild", "Warm", "Very Warm", "Hot"}; 
        if (args.length != 3)
        {
            System.out.println("Error! Please try again.");
            System.exit(0);
        }
        else
        {
            degree = Double.parseDouble(args[0]);
            celsius = args[1]; 
            fahrenheit = args[2];        
        }

        switch (celsius)    
        {
            case "c":    
            System.out.printf("%n%s Celsius is %.5s Fahrenheit %s\n", args[0], fahrenheit(degree), days[checkDegree(degree)]);
            break;
            case "f":
            System.out.printf("%n%s Fahrenheit is %.5s Celsius %s\n", args[0], celsius(degree), days[checkDegree(degree)]);
            break;
        }
    }
    public static double celsius(double fahrenheitTemperature)
    {
        return ( 5.0 / 9.0 * ((double) fahrenheitTemperature - 32));
    }
    public static double fahrenheit(double celsiusTemperature)
    {
    return  ( 9.0 / 5.0 * (double) celsiusTemperature + 32);
    }
    public static int checkDegree(double degree) {
        int myReturn = 0;
        if (degree < 0)
            {    
            myReturn = 0;
            }
            if (degree >= 0 && degree < 32)
            {    
            myReturn = 1;
            }
            if (degree >= 32 && degree < 50)
            {    
            myReturn = 2;
            }
            if (degree >= 50 && degree < 60)
            {    
            myReturn = 3;
            }
            if (degree >= 60 && degree < 70)
            {    
            myReturn = 4;
            }
            if (degree >= 70 && degree < 90)
            {    
            myReturn = 5;
            }
            if (degree >= 90)
            {    
            myReturn = 6;
            }   
            return myReturn;
    }
}