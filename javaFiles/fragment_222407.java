public class Test {

public static void main(String[] args) throws ParseException {

    DateFormat originalFormat = new SimpleDateFormat("dd-MMM-yyyy");
    DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = originalFormat.parse("09-Dec-2013");
        String formattedDate = targetFormat.format(date); 

        System.out.println(formattedDate);


    }