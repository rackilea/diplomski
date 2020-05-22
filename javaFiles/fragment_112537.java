import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

public class ReadPPTXAllText {

 public static void main(String[] args) throws Exception {

  XMLSlideShow slideShow = new XMLSlideShow(new FileInputStream("MicrosoftPowerPoint.pptx"));
  for (XSLFSlide slide : slideShow.getSlides()) {
   CTSlide ctSlide = slide.getXmlObject();
   XmlObject[] allText = ctSlide.selectPath(
    "declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' " +
    ".//a:t"
   );
   for (int i = 0; i < allText.length; i++) {
    if (allText[i] instanceof XmlString) {
     XmlString xmlString = (XmlString)allText[i];
     String text = xmlString.getStringValue();
System.out.println(text);
     if (text.toLowerCase().contains("test")) {
      String newText = text.replaceAll("(?i)" + "test", "XXXXXXXX");
      xmlString.setStringValue(newText);
     }
    }
   }
  }

  FileOutputStream out = new FileOutputStream("MicrosoftPowerPointChanged.pptx");
  slideShow.write(out);
  slideShow.close();
  out.close();
 }
}