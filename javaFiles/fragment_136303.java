public static void main(final String... args)
{
    final Pattern p = Pattern.compile("one dollar");

    final String input = "I want one dollar, please";

    // IndexOutOfBoundsException: no group 1
    System.out.println(p.matcher(input).replaceFirst("$1"));
    // You need to escape the "$"
    System.out.println(p.matcher(input).replaceFirst("\\$1"));
}