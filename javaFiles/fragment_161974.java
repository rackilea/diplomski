public class Leapyear{
    public static void main(String []args){
        for(int year =2000; year <=2020; year++){
            if(isLeapYear(year)) {
              System.out.println("Year " + year + " is a leap year");
            else
              System.out.println("Year " + year + " is not a leap year"); 
        }
     }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)) /* It will return boolean value (true or false) */
    }

}