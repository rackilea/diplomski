public class MyHandler extends DefaultHandler {
    private boolean isEmpty = false;
    private String  fewSpace;

@Override
public void endElement(String uri, String localName, String qName) throws SAXException {
    if (this.isEmpty) {
        this.fewSpace = " ";
        System.out.println(qName + this.fewSpace + " :)");
        this.isEmpty = false;
    }
}

@Override
public void characters(char[] buffer, int offset, int length) throws SAXException {
    String s = new String(buffer, offset, length);

    if (s.matches("\\s {1,}")) {
        System.out.println("This Element has empty String");
        this.isEmpty = true;
    }
}
}