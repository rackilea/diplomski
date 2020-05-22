private static final Pattern REGEX_PATTERN = 
        Pattern.compile("[^\\p{ASCII}]");

public static void main(String[] args) {
    String input = "-lrb-300-rrb-┬á922-6590";
    System.out.println(
        REGEX_PATTERN.matcher(input).replaceAll(" ")
    );  // prints "-lrb-300-rrb- 922-6590"
}