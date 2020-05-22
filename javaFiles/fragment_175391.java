public class Test {

    public static void main(String args[]) {
        String patternStr = "\\d{2}\\w{3}\\d{3}";
        Pattern pattern = Pattern.compile(patternStr);

        String input = "16FIT146";

        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {//invalid input
            System.out.println("Invalid");
        } else {//valid input
            System.out.println("Valid");
        }
    }
}