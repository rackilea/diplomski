public class CalenderUtil {

    public static void main(String[] args) {
        String TIME_FORMAT = "hh:mm a";
        String initialTime, finalTime, currentTime;

        initialTime = "9:00 AM";        finalTime = "11:00 AM";        currentTime = "10:00 AM";
        isCurrentTimeBetweenGivenTime(initialTime, finalTime, currentTime, TIME_FORMAT);

        initialTime = "9:00 AM";        finalTime = "12:00 PM";         currentTime = "11:00 AM";
        isCurrentTimeBetweenGivenTime(initialTime, finalTime, currentTime, TIME_FORMAT);

        initialTime = "8:00 AM";        finalTime = "8:00 PM";         currentTime = "11:00 AM";
        isCurrentTimeBetweenGivenTime(initialTime, finalTime, currentTime, TIME_FORMAT);

        initialTime = "8:00 AM";        finalTime = "8:00 PM";        currentTime = "11:00 PM";
        isCurrentTimeBetweenGivenTime(initialTime, finalTime, currentTime, TIME_FORMAT);

        initialTime = "8:00 PM";        finalTime = "8:00 AM";        currentTime = "11:00 AM";
        isCurrentTimeBetweenGivenTime(initialTime, finalTime, currentTime, TIME_FORMAT);

        initialTime = "8:00 PM";        finalTime = "8:00 AM";        currentTime = "6:00 AM";
        isCurrentTimeBetweenGivenTime(initialTime, finalTime, currentTime, TIME_FORMAT);
    }

    public static boolean isCurrentTimeBetweenGivenTime(String initialTime, String finalTime, String currentTime, String timeFormat) {
        System.out.print("initialTime=" + initialTime + ", finalTime=" + finalTime + ", currentTime=" + currentTime);

        boolean valid = false;
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(new Date());
        try {
            //Start Time
            Date inTime = new SimpleDateFormat("dd-MM-yyyy " + timeFormat, Locale.ENGLISH)
                    .parse(currentDate + " " + initialTime);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(inTime);

            //End Time
            Date finTime = new SimpleDateFormat("dd-MM-yyyy " + timeFormat, Locale.ENGLISH)
                    .parse(currentDate + " " + finalTime);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(finTime);

            Date actualTime = new SimpleDateFormat("dd-MM-yyyy " + timeFormat, Locale.ENGLISH)
                    .parse(currentDate + " " + currentTime);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(actualTime);

            if (inTime.after(finTime)) {
                calendar2.add(Calendar.DATE, 1);
                if (actualTime.before(finTime)) {
                    calendar3.add(Calendar.DATE, 1);
                }
            }

            if ((calendar3.after(calendar1) || calendar3.equals(calendar1))
                    && (calendar3.before(calendar2) || calendar3.equals(calendar2))) {
                valid = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(" ==> Result:" + valid);
        return valid;
    }
}