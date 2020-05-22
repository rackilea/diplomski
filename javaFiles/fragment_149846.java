String filteredLinksCssQuery = "[href]:not([href~=(?i)\\.jpe?g$]), " + //
                               "[src]:not([src~=(?i)\\.jpe?g$])";

String html = "<a href='foo.jpg'>foo</a>" + //
              "<a href='bar.svg'>bar</a>" + //
              "<script src='baz.js'></script>";

Document doc = Jsoup.parse(html);

for(Element e: doc.select(filteredLinksCssQuery)) {
    System.out.println(e);
}