// Set infobox selector (content on the right side of Wiki page)
String tableSelector = "table.infobox";
// Load document
Document doc = Jsoup.connect("http://en.wikipedia.org/wiki/Gothenburg").get();
// Select infobox element
Element infoboxEl = doc.select(tableSelector).first();
// Select all table rows inside infobox
Elements tableRows = infoboxEl.select("tr");
for (Element row: tableRows) {
    // Output the title of each row
    System.out.print(row.select("th").text() + ": ");
    // Output conent for that title
    System.out.println(row.select("td").text());
}