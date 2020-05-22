import java.util.regex.*;

class Test {
    public static void main(String[] args) {
        String hello = "HelloxxxHelloxxxHello";
        Pattern pattern = Pattern.compile("Hello");
        Matcher matcher = pattern.matcher(hello);

        int count = 0;
        while (matcher.find())
            count++;

        System.out.println(count);    // prints 3
    }
}