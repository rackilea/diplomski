public static String getLyrics(String url) throws Exception {
    int i = 0;
    StringBuilder lyrics = new StringBuilder();
    Document document = Jsoup.connect(url).get();
    Elements lines = document.select("p.verse");
    String [] verses = new String[lines.size()];
    for(Element el : lines)
        verses[i++] = el.html();        

    for(String verse : verses)
        lyrics.append(verse + System.getProperty("line.separator") + System.getProperty("line.separator"));

    return lyrics.toString().replaceAll("<br>\\s+", System.getProperty("line.separator")).trim();
}