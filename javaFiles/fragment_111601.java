import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;

import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import javax.xml.namespace.QName;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.regex.Pattern;

class StaxReadAndChangeTest {

 public static void main(String[] args) throws Exception {
  File file = new File("ReadAndWriteTest.xlsx");
  OPCPackage opcpackage = OPCPackage.open(file);

  //since there are strings in the sheet data, we need the SharedStringsTable
  PackagePart sharedstringstablepart = opcpackage.getPartsByName(Pattern.compile("/xl/sharedStrings.xml")).get(0);
  SharedStringsTable sharedstringstable = new SharedStringsTable();
  sharedstringstable.readFrom(sharedstringstablepart.getInputStream());

  //get first worksheet
  PackagePart sheetpart = opcpackage.getPartsByName(Pattern.compile("/xl/worksheets/sheet1.xml")).get(0);

  //get XML reader and writer            
  XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(sheetpart.getInputStream());
  XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(sheetpart.getOutputStream());

  XMLEventFactory eventFactory = XMLEventFactory.newInstance();

  int rowsCount = 0;
  int colsCount = 0;
  boolean cellAfound = false;
  boolean cellBfound = false;

  while(reader.hasNext()){ //loop over all XML in sheet1.xml
   XMLEvent event = (XMLEvent)reader.next();
   if(event.isStartElement()) {
    StartElement startElement = (StartElement)event;
    QName startElementName = startElement.getName();
    if(startElementName.getLocalPart().equalsIgnoreCase("row")) { //start element of row
     rowsCount++;
     colsCount = 0;
    } else if (startElementName.getLocalPart().equalsIgnoreCase("c")) { //start element of cell
     colsCount++;
     cellAfound = false;
     cellBfound = false;
     if (rowsCount % 5 == 0) { // every 5th row
      if (colsCount == 1) { // cell A
       cellAfound = true;
      } else if (colsCount == 2) { // cell B
       cellBfound = true;
      } 
     }
    } else if (startElementName.getLocalPart().equalsIgnoreCase("v")) { //start element of value
     if (cellAfound) {
      // create new rich text content for cell A
      CTRst ctstr = CTRst.Factory.newInstance();
      ctstr.setT("changed String Value A" + (rowsCount));
      //int sRef = sharedstringstable.addEntry(ctstr);
      int sRef = sharedstringstable.addSharedStringItem(new XSSFRichTextString(ctstr));
      // set the new characters for A's value in the XML
      if (reader.hasNext()) {
       writer.add(event); // write the old event
       event = (XMLEvent)reader.next(); // get next event - should be characters
       if (event.isCharacters()) {
        Characters value = eventFactory.createCharacters(Integer.toString(sRef));
        event = value;
       } 
      }        
     } else if (cellBfound) {
      // set the new characters for B's value in the XML
      if (reader.hasNext()) {
       writer.add(event); // write the old event
       event = (XMLEvent)reader.next(); // get next event - should be characters
       if(event.isCharacters()) { 
        double oldValue = Double.valueOf(((Characters)event).getData()); // old double value
        Characters value = eventFactory.createCharacters(Double.toString(oldValue * rowsCount));
        event = value;         
       }         
      }
     }
    }
   }
   writer.add(event); //by default write each read event
  }
  writer.flush();

  //write the SharedStringsTable
  OutputStream out = sharedstringstablepart.getOutputStream();
  sharedstringstable.writeTo(out);
  out.close();
  opcpackage.close();

 }
}