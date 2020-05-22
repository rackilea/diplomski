public static void main(final String... args)
        throws IOException {
    try ( final Reader reader = getPackageResourceReader(Q42938530.class, "wikiquotes.json") ) {
        final JSONTokener tokener = new JSONTokener(reader);
        final JSONObject jsonObject = (JSONObject) tokener.nextValue();
        final String quotesHtml = extractQuotesHtml(jsonObject);
        final List<String> quotes = extractQuotes(quotesHtml);
        for ( final String quote : quotes ) {
            System.out.println(quote);
        }
    }
}

private static String extractQuotesHtml(final JSONObject jsonObject) {
    return jsonObject
            .getJSONObject("parse")
            .getJSONObject("text")
            .getString("*");
}

private static List<String> extractQuotes(final String quotesHtml) {
    final Document document = Jsoup.parse(quotesHtml);
    final List<String> quotes = new ArrayList<>();
    final Elements elements = document.select("ul > li");
    for ( final Element element : elements ) {
        quotes.add(element.text());
    }
    return quotes;
}