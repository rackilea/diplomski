public static String getOutput(char units, double degrees) { 
    if ((units == 'F') || (units == 'f'))
    {
      String output = " ";
      output = degrees + " degrees F = " + convertToCelsius(degrees) + " degrees Celsius.";
      return output;
    }
    else if ((units) == 'C' || (units) == 'c' )
    {
      String output = " ";
      output = degrees + " degrees C = " + convertToFahrenheit(degrees) + " degrees Fahrenheit.";
      return output;
    }
    if(!(units == 'F' || units == 'f' || units == 'C' || units == 'c'))
    {
      String output = ("Unknown units - cannot do calculation\n" + 
                    " - next time enter either \'F\' for Fahrenheit or \'C\' for Celsius.");
      return output;
    }
    return "";
  }