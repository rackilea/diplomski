String testString = "Lorem ipsum dolor sit amet.";

Pattern pattern = Pattern.compile("\\w+");
Matcher matcher = pattern .matcher(testString);
String lastSingleWord = null;
List<String> results = new ArrayList<>();

while (matcher.find()) {
    String singleWord = matcher.group(0);
    if (lastSingleWord != null) {
        results.add(lastSingleWord + " " + singleWord);
    }
    lastSingleWord = singleWord;
}