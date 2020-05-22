public static void main(final String[] args)
{
    final String html = "<p>My mother has\n" +
            "<span style=\"color:blue;font-weight:bold\">blue</span>\n" +
            "eyes and my father has\n" +
            "<span style=\"color:darkolivegreen;font-weight:bold\">\n" +
            "dark green</span>\n" +
            "eyes.</p>\n" +
            "<h2>Mr. <span style=\"color:green\">Foobar</span></h2>";

    final Document document = Jsoup.parse(html);

    final Elements textNodes = document.select("p,h2");

    for (final Element element : textNodes)
    {
        System.out.println("Found: " + element.text());

        System.out.println("\t Neasted Spawns:");
        for (final Element span : element.select("span"))
        {
            System.out.println("\t\t css: " + span.attr("style"));
        }
    }
}