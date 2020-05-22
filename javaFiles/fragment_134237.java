public class DateTime_CLIENT{
    public static void main(){
        DateTime dt = new DateTime();

        System.out.println("- DateTime -");
        System.out.println("Date: " + dt);
        System.out.println("Month: " + dt.getMonth());
        System.out.println("Day: " + dt.getDay());
        System.out.println("Year: " + dt.getYear() + "\n");

        DateTime2 dt2 = new DateTime2();

        System.out.println("- DateTime2 -");
        System.out.println("Date: " + dt2);
        System.out.println("Month: " + dt2.month);
        System.out.println("Day: " + dt2.day);
        System.out.println("Year: " + dt2.year + "\n");

        dt2.day = 400000;

        System.out.println("- DateTime2 - CHANGE FROM CLIENT");
        System.out.println("Date: " + dt2);
        System.out.println("Month: " + dt2.month);
        System.out.println("Day: " + dt2.day);
        System.out.print("Year: " + dt2.year);
    }
}