import org.xml.sax.*;
import org.xml.sax.ext.*;
import org.xml.sax.helpers.*;

import java.io.IOException;

public class Test implements LexicalHandler, ContentHandler {

  private String  lastComment;

  public void startDTD(String name, String publicId, String systemId) throws SAXException {
  }
  public void endDTD() throws SAXException {
  }
  public void startEntity(String name) throws SAXException {
  }
  public void endEntity(String name) throws SAXException {
  }
  public void startCDATA() throws SAXException {
  }
  public void endCDATA() throws SAXException {
  }
  public void comment(char[] text, int start, int length) throws SAXException {
    this.lastComment = new String(text, start, length).trim();
  }

  public void characters(char[] ch, int start, int length) {
  }
  public void endDocument() {
  }
  public void endElement(String uri, String localName, String qName) {
  }
  public void endPrefixMapping(String prefix) {
  }
  public void ignorableWhitespace(char[] ch, int start, int length) {
  }
  public void processingInstruction(String target, String data) {
  }
  public void setDocumentLocator(Locator locator) {
  }
  public void skippedEntity(String name) {
  }
  public void startDocument() {
  }
  public void startElement(String uri, String localName, String qName, Attributes atts) {
    if (localName == "object") {
      if (this.lastComment != null) {
        System.out.println("Element object with comment found: \"" + this.lastComment + "\"");
        this.lastComment = null;
      }
    } else {
      this.lastComment = null;
    }
  }
  public void startPrefixMapping(String prefix, String uri) {
  }

  public static void main(String[] args) {
    Test test = new Test();
    XMLReader parser;

    try {
      parser = XMLReaderFactory.createXMLReader();
    } catch (SAXException ex1) {
      try {
        parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
      } catch (SAXException ex2) {
        return;
      }
    }

    try {
      parser.setProperty("http://xml.org/sax/properties/lexical-handler", test);
    } catch (SAXNotRecognizedException e) {
      System.out.println(e.getMessage());
      return;
    } catch (SAXNotSupportedException e) {
      System.out.println(e.getMessage());
      return;
    }

    parser.setContentHandler(test);

    try {
      parser.parse("test.xml");
    } catch (SAXParseException e) {
      System.out.println(e.getMessage());
    } catch (SAXException e) { 
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}