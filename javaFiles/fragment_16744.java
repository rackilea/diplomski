for( Element element : doc.select("p.plrow") )
{
    String title = element.ownText();                           // Title - output: '“Title” ()' (you have to replace the " and () here)
    String artist = element.select("a").first().text();         // Artist
    String label = element.select("span.sn_ld").first().text(); // Label

    // etc.
}