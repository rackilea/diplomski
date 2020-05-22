private static void printfWithLocale(Locale locale, Double d){
    System.out.println("Output locale: " + locale.toString());
    String simpleOutputTeplate = "simpleOutputTeplate: %s";
    String refinedOutputTeplate = "refinedOutputTeplate: %.10f";

    System.out.println(String.format(locale, simpleOutputTeplate, d));
    System.out.println(String.format(locale, refinedOutputTeplate, d));

  }

  public static void main(String[] args) {

    Double d = new Double(3.1234567890123456789);

    printfWithLocale(Locale.US, d);
    System.out.println("");
    printfWithLocale(Locale.FRANCE, d);
  }