import java.util.regex.*;

class Test {
    public static void main(String[] args) {
        String hello = "HelloxyzxyzxyzHello";
        Pattern pattern = Pattern.compile("(?:Hello|(?<!^)\\G)(?:(?!Hello).)*?(xyz)(?=.*?Hello)");
        Matcher  matcher = pattern.matcher(hello);

        int count = 0;
        while (matcher.find()) {
            if (matcher.group(1)) {
            count++;
             }
         }
        System.out.println(count);    // prints 3
    }
}