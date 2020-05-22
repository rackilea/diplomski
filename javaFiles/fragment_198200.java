import javax.xml.parsers.*;
import org.w3c.dom.*;

class Example {
    public static final void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("book.xml");
        NodeList bookshelves = document.getElementsByTagName("bookshelf");
        if (bookshelves.getLength() > 0) {
            Element bookshelf = (Element)bookshelves.item(0);
            NodeList children = bookshelf.getChildNodes();
            for (int i = 0, l = children.getLength(); i < l; ++i) {
                Node child = children.item(i);
                if (child.getNodeName().equals("book")) {
                    Element book = (Element)child;
                    System.out.println(book.getAttribute("ISBN"));
                    System.out.println(book.getAttribute("press"));
                }
            }
        }
    }
}