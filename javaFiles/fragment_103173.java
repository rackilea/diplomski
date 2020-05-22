public class Month{
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    ...

    public static String getName(final int month){
        if(month <= 0 || month > 12){
            throw new IllegalArgumentException("Invalid month number: " + month);
        }

        ...
    }
}