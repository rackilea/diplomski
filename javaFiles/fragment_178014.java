public static void main(String[] args) {
    Pattern pattern = Pattern.compile("/(.*)\"");
    Pattern pattern1 = Pattern.compile("((?:.(?<!/))+)\"");
    String matchString = "/slm/attachment/63338424306/Note.jpg\"xxxxxxxx";
    Matcher matcher = pattern.matcher(matchString);
    String fullString = "";
    while (matcher.find()) {
        fullString = matcher.group(1);
    }
    matcher = pattern1.matcher(matchString);
    String fileName = "";
    while (matcher.find()) {
        fileName = matcher.group(1);
    }

    System.out.println(fullString + " " + fileName);
}