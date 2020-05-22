public class TimeDiffereneceTest {

static String secondDate,firstDate, dateDifference;
static SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy/MM/dd");


public static void main(String[] args) {
    firstDate = "2014/07/20";
    secondDate = getTodayDate();     // Generate 2014/07/23

    DateDifference(firstDate, secondDate);

}

public static String getTodayDate() {
    Calendar todayDate = Calendar.getInstance();
    String strDate = simpleFormat.format(todayDate.getTime());
    return strDate;
}

public static void DateDifference(String firstDate,String nowDate) {
    Date d1=null;
    Date d2=null;


    try{
        d1 = simpleFormat.parse(firstDate);
        d2 = simpleFormat.parse(nowDate);

        DateTime dt1 = new DateTime(d1);
        DateTime dt2 = new DateTime(d2);

        System.out.println("Day difference is: "+Days.daysBetween(dt1, dt2).getDays()); // 206!

    }
    catch(Exception e){
        e.printStackTrace();
    }

}
}