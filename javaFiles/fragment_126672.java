public class PageHandler extends DefaultHandler {

    private final PageProcessor processor;
    private Page page;
    private StringBuilder stringBuilder;
    private boolean idSet = false;

    public PageHandler(PageProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
         //Unchanged from your implementation
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
         //Unchanged from your implementation
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
            //  Elide code not needing change

            } else if (qName.equals("page")){

                processor.process(page);
                page = null;

            }
        } else {
            page = null;
        }
    }

}