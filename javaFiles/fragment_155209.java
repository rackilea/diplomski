Iterable<Element> it = Iterables.concat(
    doc.select("a[title=Flera bilder]"),
    doc.select("a[title=\"\"]"),
    doc.select("a[title=Bild]"));
for (Element element : it) {
  String myElement = element.attr("abs:href");
  System.out.println(myElement);
}