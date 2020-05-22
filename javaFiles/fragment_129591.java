public static void main(final String[] args) {

    List<String> points = new ArrayList<>();
    System.out.println("Enter coordinates: ");

    String blocks = "((1 2),(3 4))";
    foo(blocks, points);
    blocks = "( 1 2)"; //intentionally added space to the input
    foo(blocks, points);
    blocks = "((1 2),(3 4),(8 7))";
    foo(blocks, points);
    System.out.println(points);

}

private static void foo(final String blocks, final List<String> points) {
    Matcher match = Pattern.compile("\\((.+?)\\)").matcher(blocks);
    while (match.find()) {
        String x = match.group(1).replace("(", "").trim();

        System.out.println(x);
        points.add(x);
    }
}