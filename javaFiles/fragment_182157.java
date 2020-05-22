public static void main(String[] args) {

    Pattern pat = Pattern.compile("testing (\\d+) widgets");

    String text = "testing 5 widgets";

    Matcher matcher = pat.matcher(text);

    if (matcher.matches()) {
        System.out.println("Widgets tested : " + matcher.group(1));
    } else {
        System.out.println("No match");
    }

}