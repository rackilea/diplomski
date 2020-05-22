public class Quotes {
    Hashtable cache;

    public Quotes() {
       cache = new Hashtable();
    }

    public String getQuote(int person, int quoteNumber) {
        if (!cache.containsKey(new Integer(person))) {
           try {
               loadQuoteFile(person);
           } catch (IOException e) {
               // Invalid person / file - do what you will
           }
        }

        String[] quotes = (String[])cache.get(new Integer(person));
        if (quoteNumber < 0) return quotes[0];
        if (quoteNumber >= quotes.length) return quotes[quotes.length - 1];
        return quotes[quoteNumber];
    }

    private void loadQuoteFile(int person) throws IOException {
        String[] quotes;
        // Load the file
        // Parse into strings using linebreaks as the delimiter
        cache.put(new Integer(person), quotes);
    }
}