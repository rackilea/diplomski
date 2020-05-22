public class Parser {
    public void parseAndWrite() {

        Document doc;
        try {
            doc = Jsoup.connect(" https://www.ote-cr.cz/en/statistics/electricity-imbalances-1").get();

            PrintWriter writer = new PrintWriter(new File("out.html"));
            System.out.println(doc);
            Element tableElement = doc.select("div.bigtable").first();

            writer.write(tableElement.toString());

            writer.close();
        } catch (IOException e) {
            // LOG may be?
        }
    }