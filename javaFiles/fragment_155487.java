File file = new File("data.txt");
Pattern ip = Pattern.compile("(\\d{1,3}\\.){3}\\d{1,3}");
Pattern date = Pattern.compile("\\[.*(?= \\+\\d+\\])");
Pattern type = Pattern.compile("\"\\w+(?= )");
Pattern url = Pattern.compile("(https?:\\/\\/)([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?");
Scanner s = new Scanner(file);
while (s.hasNextLine()) {
    String text = s.nextLine();
    Matcher[] m = new Matcher[]{ip.matcher(text), date.matcher(text), type.matcher(text), url.matcher(text)};
    boolean isMatch = true;
    for (Matcher matcher : m) {
        if (!matcher.find()) {
            isMatch = false;
            break;
        }
    }
    if (isMatch) {
        System.out.println(m[0].group() + "," + m[1].group().substring(1) + "," + m[2].group() + "\"," + m[3].group().replaceAll("http://", "").replaceAll("https://", ""));
    }
}