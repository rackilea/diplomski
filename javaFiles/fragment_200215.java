import nu.xom.*;

public class LibraryProcessor extends NodeFactory {
  private Nodes empty = new Nodes();
  private bookNum = 0;

  /** Called for each closing tag in the XML */
  public Nodes finishMakingElement(Element element) {
    if("Book".equals(element.getLocalName())) {
      bookNum++;
      // process the complete Book element ...
      processBook(element);
      // ... and throw it away
      return empty;
    } else {
      // process other elements (except Book) in the normal way
      return super.finishMakingElement(element);
    }
  }

  private void processBook(Element book) {
    System.out.println(bookNum + ": " +
        book.getAttributeValue("name"));
    System.out.println("Author: " +
        book.getFirstChildElement("Author").getValue());
    System.out.println("PrintCompany Detail XML: " +
        book.getFirstChildElement("PrintingCompanyDT").toXML());
  }

  public static void main(String[] args) throws Exception {
    Builder builder = new Builder(new LibraryProcessor());
    builder.build(new File(args[0]));
  }
}