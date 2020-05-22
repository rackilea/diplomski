public static void main(String args[]) {
    final Pattern pattern = Pattern.compile("(\\d++)\\.([^,]++),\\s*+([^,]++),\\s*+(.*+)");
    final Matcher matcher = pattern.matcher("");
    //for each input string
    final String input = "Subject, Uni Name, Location 2";
    matcher.reset(input);
    final String output = matcher.replaceAll("$1, $3, $2, $4");
    System.out.println(output);
}