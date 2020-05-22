public static boolean findSpecialChar(String input) {
    Pattern pattern = Pattern.compile("[#%&*:<>?/{|}]");
    Matcher matcher = pattern.matcher(input);
    // Check if the regex can be found anywhere
    return matcher.find();
}

public static void main(String[] args) {
    System.out.println(findSpecialChar("#fdhdfjdf"));
    System.out.println(findSpecialChar("fdhdfjdf"));
}