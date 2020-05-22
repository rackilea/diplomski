try {
    String input = "12/31/2014XYZ";

    ParsePosition pp = new ParsePosition(0);
    sdf.parse(input, pp);

    // Make sure the entire string was parsed
    if (pp.getIndex() != input.length())
        throw new Exception();

    System.out.println("Valid Date");
} catch (Exception e) {
    System.out.println("Invalid Date");
}