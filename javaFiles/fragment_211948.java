public class CloseableXmlEventReader implements XMLEventReader, AutoCloseable{

    private final XMLEventReader internal;

    public CloseableXmlEventReader(XMLEventReader internal) {
        this.internal = internal;
    }

    @Override
    public XMLEvent nextEvent() throws XMLStreamException {
        return internal.nextEvent();
    }

    @Override
    public boolean hasNext() {
        return internal.hasNext();
    }

    @Override
    public XMLEvent peek() throws XMLStreamException {
        return internal.peek();
    }

    @Override
    public String getElementText() throws XMLStreamException {
        return internal.getElementText();
    }

    @Override
    public XMLEvent nextTag() throws XMLStreamException {
        return internal.nextTag();
    }

    @Override
    public Object getProperty(String name) throws IllegalArgumentException {
        return internal.getProperty(name);
    }

    @Override
    public void close() throws XMLStreamException {
        internal.close();
    }

    @Override
    public Object next() {
        return internal.next();
    }
}