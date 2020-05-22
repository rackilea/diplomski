public class Example {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Year:");
        int year = sc.nextInt();

        System.out.println("Date-time in format: dd.MM. HH:mm");
        sc.nextLine();
        sc.findInLine("(\\d\\d)\\.(\\d\\d)\\. (\\d\\d):(\\d\\d)");
        try {
            MatchResult mr = sc.match();
            int month = Integer.parseInt(mr.group(2));
            int day = Integer.parseInt(mr.group(1));
            int hour = Integer.parseInt(mr.group(3));
            int minute = Integer.parseInt(mr.group(4));
            LocalDateTime dt = LocalDateTime.of(year, month, day, hour, minute);
            System.out.println(dt);
        } catch (IllegalStateException e) {
            System.err.println("Invalid date-time format.");
        }
    }
}