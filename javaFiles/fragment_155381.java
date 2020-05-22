public static boolean findSpecialChar(String input) {
    // Use .* to indicate there can be anything and this special chars
    String regex = ".*[#%&*:<>?/{|}].*";
    return input.matches(regex);
}

public static void main(String[] args) {
    System.out.println(findSpecialChar("#fdhdfjdf"));
    System.out.println(findSpecialChar("fdhdfjdf"));
}