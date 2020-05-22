public class goFile {
    public static int SubtractTime(String number1, String number2)
    {
        return Math.abs(ConvertTimeToMinutes(number2) - ConvertTimeToMinutes(number1));
    }

    public static int ConvertTimeToMinutes(String number)
    {
        return Integer.parseInt(number.substring(0, 2))*60 + Integer.parseInt(number.substring(2, 4));
    }

    public static void main(String[] args) {
        System.out.println(SubtractTime("0925", "1010"));
        System.out.println(SubtractTime("1015", "1025"));
    }
}