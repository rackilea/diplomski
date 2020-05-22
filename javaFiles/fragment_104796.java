public static final String EXAMPLE_TEST = "Your string here : { } . / []";

public static void main(String[] args) {
    Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>\\[\\]]");
    Matcher matcher = pattern.matcher(EXAMPLE_TEST);
    if (matcher.find())
        System.out.println("found");
    else {
        System.out.println("not found");
    }
}