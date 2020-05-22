import java.util.GregorianCalendar;

//january, 1st, 2012
GregorianCalendar c1 = new GregorianCalendar(2012, 0, 1);
//march, 3rd, 1912
GregorianCalendar c2 = new GregorianCalendar(1912, 2, 3);
long differenceInSeconds = (c1.getTimeInMillis() - c2.getTimeInMillis()) / 1000;