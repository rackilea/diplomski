public static List<String> getLinks(String text) {
    Matcher matcher = Pattern.compile("<tagstart>(.*?)<tagend>").matcher(text);
    List<String> linkList = new ArrayList<String>();
    while (matcher.find()) {
        linkList.add(matcher.group(1));
    }
    return linkList;
}