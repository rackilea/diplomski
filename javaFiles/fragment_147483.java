import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public class RemoveComments {
    public static void main(String... args) {
        String h = "<html><head></head><body>" +
          "<div><!-- foo --><p>bar<!-- baz --></div><!--qux--></body></html>";
        Document doc = Jsoup.parse(h);
        removeComments(doc);
        doc.html(System.out);
    }

    private static void removeComments(Node node) {
        for (int i = 0; i < node.childNodeSize();) {
            Node child = node.childNode(i);
            if (child.nodeName().equals("#comment"))
                child.remove();
            else {
                removeComments(child);
                i++;
            }
        }
    }        
}