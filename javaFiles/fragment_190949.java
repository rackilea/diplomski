public void setFraction(String a)
{
    System.out.println(a);
    //Right here it's saying it's null, I don't understand why...
    String[] stringReducedFraction = a.split("/");
    double numerator = Float.valueOf(stringReducedFraction[0]);
    double denominator = Float.valueOf(stringReducedFraction[1]);
    //split up the string here for other uses
 }