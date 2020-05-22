HtmlCleaner cleaner = new HtmlCleaner();
final String siteUrl = "http://www.themoscowtimes.com/";

TagNode node = cleaner.clean(new URL(siteUrl));


// serialize to xml file
new PrettyXmlSerializer(props).writeToFile(
    node , "cleaned.xml", "utf-8"
);