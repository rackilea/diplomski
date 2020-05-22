public class Test4 {
    static String pattern = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        final Scanner input = new Scanner(System.in);
        System.out.println("input date: ");
        String a = input.nextLine();
        c = strToCal(a);
        System.out.println(c.getTime());
    }


    static Calendar strToCal(String s) {
        try {
            DateFormat df = new SimpleDateFormat(pattern);
            Calendar cal = Calendar.getInstance();
            cal.setTime(df.parse(s));
            return cal;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}