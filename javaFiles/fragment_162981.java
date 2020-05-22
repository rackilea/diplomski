public static void main(final String... args)
{
    final Pattern p = Pattern.compile("cat$");

    final Matcher m = p.matcher("I have a cat");
    m.find(); // finds a match
    System.out.println(m.requireEnd()); // prints true
}