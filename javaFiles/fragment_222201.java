public class Lists {

    public static void main (String[] args)
    {
        ArrayList<String> DaysOfTheWeek = new ArrayList<String>();

        DaysOfTheWeek.add("Sunday");
        DaysOfTheWeek.add("Tuesday");
        DaysOfTheWeek.add("Wednesday");
        DaysOfTheWeek.add("Thursday");

        DaysOfTheWeek.add(1, "Monday");
    }
}