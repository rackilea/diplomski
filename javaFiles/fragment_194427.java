public class GregorianDate extends Date {
    //Define constants
    private final static int MONTH = 1;
    private final static int DAY = 1;
    private final static int YEAR = 1970;


    //*************** Constructors ***********************
    GregorianDate() {
        super(MONTH,DAY,YEAR);
        long numToAdd = System.currentTimeMillis();
        numToAdd += java.util.TimeZone.getDefault().getRawOffset();
        numToAdd /= 86400000;
        super.addDays(numToAdd);
    }

    //Parameterized constructor
    GregorianDate(int passedYear, int passedMonth, int passedDay){
        super(passedMonth, passedDay, passedYear);
    }

    //getters and setters here
}