public class DateSunday {

static Calendar mCalendar= Calendar.getInstance();

public static void main(String[] args){

    for(int i=0;i<10;i++){
        onClick();
    }
}

public static void onClick(){
    SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    mCalendar.add(Calendar.DAY_OF_WEEK, 1);

    Calendar sundayCalendar=Calendar.getInstance();
    sundayCalendar.setTime(mCalendar.getTime());
    sundayCalendar.set(Calendar.DAY_OF_WEEK, mCalendar.get(Calendar.SUNDAY));

    System.out.println(" - " + mSimpleDateFormat.format(sundayCalendar.getTime()));

    }
}