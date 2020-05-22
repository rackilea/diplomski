public static void main(String[] args) {
    String regex = "[^,']+";
    Pattern pat = Pattern.compile(regex);
    Matcher matcher = pat.matcher("'John', 'Smith'");
    List<String> matches = new ArrayList<>();
    while (matcher.find()) {
        matches.add(matcher.group());
    }
    System.out.println(matches);
}