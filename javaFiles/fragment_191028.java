Document doc = Jsoup.connect("http://wikitravel.org/en/San_Francisco").get();
//select all "next siblings" of the "Get around" h2
Elements section = doc.select("h2:contains(Get around) ~ *");
//select all "next siblings" of the "See" h2 and remove them
section.select("h2:contains(See) ~ *").remove();
//remove the second h2
section.select("h2").remove();
//section now contains the elements between "Get around" and "See"
String sectionHtml = section.html();