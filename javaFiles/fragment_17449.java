import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSSHandler extends DefaultHandler {

    private State currentState = State.unknown;

    private RSSFeed feed;
    private RSSItem item;

    private boolean itemFound = false;

    private StringBuilder tagContent;

    public RSSHandler() {
    }

    @Override
    public void startDocument() throws SAXException {
        feed = new RSSFeed();
        item = new RSSItem();
    }

    @Override
    public void startElement(final String uri, final String localName, 
            final String qName, final Attributes attributes)
            throws SAXException {
        currentState = State.unknown;
        tagContent = new StringBuilder();
        if (localName.equalsIgnoreCase("item")) {
            itemFound = true;
            item = new RSSItem();
            currentState = State.unknown;
        } else if (localName.equalsIgnoreCase("title")) {
            currentState = State.title;
        } else if (localName.equalsIgnoreCase("description")) {
            currentState = State.description;
        } else if (localName.equalsIgnoreCase("link")) {
            currentState = State.link;
        } else if (localName.equalsIgnoreCase("pubdate")) {
            currentState = State.pubdate;
        }
        System.out.println("new state: " + currentState);

    }

    @Override
    public void endElement(final String uri, final String localName, 
            final String qName) throws SAXException {
        if (localName.equalsIgnoreCase("item")) {
            feed.addItem(item);
        }
        if (itemFound == true) {
            // "item" tag found, it's item's parameter
            switch (currentState) {
                case title:
                    item.setTitle(tagContent.toString());
                    break;
                case description:
                    item.setDescription(tagContent.toString());
                    break;
                case link:
                    item.setLink(tagContent.toString());
                    break;
                case pubdate:
                    item.setPubdate(tagContent.toString());
                    break;
                default:
                    break;
            }
        } else {
            // not "item" tag found, it's feed's parameter
            switch (currentState) {
                case title:
                    feed.setTitle(tagContent.toString());
                    break;
                case description:
                    feed.setDescription(tagContent.toString());
                    break;
                case link:
                    feed.setLink(tagContent.toString());
                    break;
                case pubdate:
                    feed.setPubdate(tagContent.toString());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void characters(final char[] ch, final int start, final int length) 
            throws SAXException {
        tagContent.append(ch, start, length);
    }

    public RSSFeed getFeed() {
        return feed;
    }

}