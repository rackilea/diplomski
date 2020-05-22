public class Main
{
    static OptionalInt parseOnlyInt(String s)
    {
        String digitsOnly = s.replaceAll("[^0-9]", "");
        if (digitsOnly.length() == 0)
            return OptionalInt.empty();
        else
            return OptionalInt.of(Integer.parseInt(digitsOnly));
    }

    public static void main(String[] args)
    {
        int sum = Arrays.stream(args)
                .map(Main::parseOnlyInt)
                // probably in Java 9 OptionalInt::stream would be better than next 2 lines
                // see https://bugs.openjdk.java.net/browse/JDK-8050820
                .filter(OptionalInt::isPresent)
                .mapToInt(OptionalInt::getAsInt)
                .sum(); 

        System.out.println(Arrays.toString(args));
        System.out.println(sum);    
    }
}