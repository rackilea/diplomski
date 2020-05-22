public class Main {    
    public static Date checkDate(final String dt) throws ParseException {

        final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        final SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
        final SimpleDateFormat sdf3 = new SimpleDateFormat("dd MM yyyy");

        Date date = null;

        try {
            date = sdf1.parse(dt);
        } catch (final ParseException e) {
            try {
                date = sdf2.parse(dt);
            } catch (final ParseException e1) {
                try {
                    date = sdf3.parse(dt);
                } catch (final ParseException e2) {
                    final String invalid = "Invalid,Retry";
                    System.out.println(invalid);
                }
            }
        }
        return date;
    }

    public static void main(final String[] args) throws ParseException {
        final Scanner scanner = new Scanner(System.in);
        final EmployeeInfo e = new EmployeeInfo();
        System.out.println("Enter the name: ");
        e.setName(scanner.nextLine());
        Date d = null;
        while (d == null) {
            System.out.println("Enter the Date Of Birth: ");
            d = checkDate(scanner.nextLine());
        }
        e.setDateOfBirth(d);
        d = null;
        while (d == null) {
            System.out.println("Enter the Date of Joining: ");
            d = checkDate(scanner.nextLine());
        }
        e.setDateOfJoining(d);

        e.print();

    }
}