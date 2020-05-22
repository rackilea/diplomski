public static String LeapYear(int y) {
 int theYear;
 theYear = y;
 String LEAP_YEAR = "IT IS A LEAP YEAR";
 String NOT_A_LEAP_YEAR = "IT IS NOT A LEAP YEAR";

 if (theYear < 100) {
    if (theYear > 40) {
        theYear = theYear + 1900;
    } else {
        theYear = theYear + 2000;
    }
 }

if (theYear % 4 == 0) {
    if (theYear % 100 != 0) {
        //System.out.println("IT IS A LEAP YEAR");
        return LEAP_YEAR;

    } else if (theYear % 400 == 0) {
        //System.out.println("IT IS A LEAP YEAR");
        return LEAP_YEAR;
    } else {
       // System.out.println("IT IS NOT A LEAP YEAR");
       return NOT_A_LEAP_YEAR ;
    }
  } else {
    //System.out.println("IT IS NOT A LEAP YEAR");
    return NOT_A_LEAP_YEAR ;
  }
 return NOT_A_LEAP_YEAR ;
}