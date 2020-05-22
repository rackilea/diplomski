import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    import java.util.Date;

    public class Main {

        public static void main(String[] args) {
            Date today = new Date();
            DateFormat timeFormat = SimpleDateFormat.getTimeInstance();
            DateFormat dateFormat = SimpleDateFormat.getDateInstance();
            timeFormat.format(today);
            dateFormat.format(today);
            System.out.println("Time: " + timeFormat.format(today));
            System.out.println("Date: " + dateFormat.format(today));
        }
    }