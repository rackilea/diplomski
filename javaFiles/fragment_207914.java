import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseXML extends DefaultHandler {

    private Library lib;
    private List<Book> extraBooks = new ArrayList<Book>();
    private List<Book> currentList = extraBooks;

    public ParseXML(String file) throws ParserConfigurationException, SAXException, IOException {
        parse(file);
    }

    private void parse(String file) throws ParserConfigurationException, SAXException, IOException {
        final SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser parser = factory.newSAXParser();
        parser.parse(file, this);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("read") || qName.equals("unread"))
            currentList = extraBooks;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("library")) {
            String name = attributes.getValue("name");
            lib = new Library(name);
        }
        else if (qName.equals("read")) {
            currentList = lib.getReadBooks();
        }
        else if (qName.equals("unread")) {
            currentList = lib.getUnreadBooks();
        }
        else if (qName.equals("book")) {
            String id = attributes.getValue("id");
            String lang = attributes.getValue("lang");
            String title = attributes.getValue("title");
            String author = attributes.getValue("author");

            currentList.add(new Book(id, lang, title, author));
        }
    }

    /**
     * @return the lib
     */
    public Library getLibrary() {
        return lib;
    }

}