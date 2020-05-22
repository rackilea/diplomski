public class Day {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter today's day: ");
        String day = input.next();
        int todayDay = changeToString(day);
        System.out.println(todayDay);
    }

    public static int changeToString(String day) {
        int dayName = 0;

        switch (day) {
            case "Monday":
                dayName = 1;
                break;
            case "Tuesday":
                dayName = 2;
                break;
             ......
        }

        return dayName;
    }
}