public class TimeMilisecond {
  public static void main(String[] argv) throws ParseException {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    String dateInString = "22-01-2015 10:20:56";
    Date date = sdf.parse(dateInString);

    System.out.println(dateInString);
    System.out.println("Date - Time in milliseconds : " + date.getTime());

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    System.out.println("Calender - Time in milliseconds : " + calendar.getTimeInMillis());

  }
}