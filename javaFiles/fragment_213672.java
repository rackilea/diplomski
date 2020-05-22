public class SimpleTest {

    public static final String HTML = "<p> This is paragraph 1 </p>\n"
                                    + "This is paragraph 2\n"
                                    + "<p> This is paragraph 3 </p>";

    public static void main(String[] args) {

        Document doc = Jsoup.parse(HTML);

        List<Node> nodes = doc.body().childNodes();

        for ( Node node : nodes ) {
            System.out.printf("Node of %s, %s%n", node.getClass(), node);
        }
    }
}