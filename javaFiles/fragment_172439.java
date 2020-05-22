public static void main(final String[] args) {
    final String input = "<span style=\"font-family: Arial;\">TEXT</span>";
    final OutputSettings settings = new OutputSettings();
    settings.prettyPrint(false);
    final Document document = Jsoup.parseBodyFragment(input);
    document.outputSettings(settings);
    final Tag tag = Tag.valueOf("arial");
    final Element span = document.getElementsByTag("span").get(0);
    final Element newElement = new Element(tag, "");
    newElement.html(span.html());
    span.replaceWith(newElement);
    System.out.print(document.body().children());
}