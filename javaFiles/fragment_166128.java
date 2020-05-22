public class TextParser
{
    public static void main(String[] args)
    {
        String line = "Cost: 7.0";

        // this will not work, it tries to parse the whole line
        //float number1 = Float.valueOf(line);

        // this works and returns 7 as a number
        float number2 = Float.valueOf(line.substring(6));

        System.out.println("the number is: " + number2);

        // you can now do calculations with it:
        System.out.println(number2 + 5);
        System.out.println(number2 * 12.345);
    }
}