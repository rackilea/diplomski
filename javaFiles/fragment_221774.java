public class Foo {
    public static void main(String... args) {
        String xml = "<p>The <ORGANIZATION>Peter Hall Company</ORGANIZATION>'s production of ''Blithe Spirit,'' directed by <PERSON>Thea Sharrock</PERSON>, is one of those attractively and unimaginatively upholstered productions of brittle classics that become must-have middlebrow tickets every few years. Most notable for <PERSON>Penelope Keith</PERSON>'s startlingly brisk and no-nonsense interpretation of the madcap medium <ORGANIZATION>Madame Arcati</ORGANIZATION>, Ms. <PERSON>Sharrock</PERSON>'s take on <PERSON>Coward</PERSON>'s 1941 comedy of a man visited by his dead wife's impish spirit delivers bright badinage, dazed double takes and marital melees at the same efficient clip.</p>";
        Document doc = Jsoup.parse(xml);

        for (Element e: doc.select("p > ORGANIZATION, p > PERSON")) {
            System.out.printf("-> %s: %s\n", e.tagName(), e.text());
            e.replaceWith(new TextNode(e.text(), ""));
        }

        System.out.println("\nFiltered out:\n" + doc.select("p").html());
    }
}