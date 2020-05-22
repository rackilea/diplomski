import java.io.*;
import org.apache.poi.*;
import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;

import java.util.GregorianCalendar;

public class DocumentProperties {

 public static void main(String[] args) throws IOException {

  XWPFDocument document = new XWPFDocument(new FileInputStream("This is a Test.docx"));

  POIXMLProperties properties = document.getProperties();
  //http://poi.apache.org/apidocs/org/apache/poi/POIXMLProperties.html

  //prints the core property Creator:
  System.out.println(properties.getCoreProperties().getCreator());

  //prints the extendend property Application:
  System.out.println(properties.getExtendedProperties().getApplication());

  //sets a custom property
  POIXMLProperties.CustomProperties customproperties = properties.getCustomProperties();
  if (!customproperties.contains("Test")) {
   customproperties.addProperty("Test", 123);
  }
  CTProperty ctproperty = customproperties.getProperty("Test");
  System.out.println(ctproperty);
  System.out.println(ctproperty.getI4());

  //the above customproperties.addProperty() can only set boolean, double, integer or string properties
  //the CTProperty contains more possibitities
  if (!customproperties.contains("Test Date")) {
   customproperties.addProperty("Test Date", 0);
   ctproperty = customproperties.getProperty("Test Date");
   ctproperty.unsetI4();
   ctproperty.setFiletime(new GregorianCalendar(2016,1,13));
  }
  ctproperty = customproperties.getProperty("Test Date");
  System.out.println(ctproperty);
  System.out.println(ctproperty.getFiletime());


  FileOutputStream out = new FileOutputStream(new File("This is a Test.docx"));
  document.write(out);
 }
}