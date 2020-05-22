public static void main(String[] args) {

    final ArrayList<String> entries = new ArrayList<String>();
    entries.add("text1/*");
    entries.add("text2/*/*");
    entries.add("text2/*/*/*");
    entries.add("text1/*/*");
    entries.add("text1/value1/*");
    entries.add("*/*");

    final Pattern pattern = Pattern.compile("^([^/*]+)/([^/*]+)/[*]$", 2);

    for (String entry : entries) {
        Matcher matcher = pattern.matcher(entry);
        while (matcher.find()) {
            System.out.println("found correct entry: " + entry);
        }
    }
}