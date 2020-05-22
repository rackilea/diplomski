import java.io.*;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.ooxml.POIXMLProperties.CoreProperties;

import java.util.Enumeration;
import java.util.GregorianCalendar;

import java.util.zip.*;

public class CreateXWPFFixedZIPCreationDateTime {

 static byte[] createXWPFZIPArchive() throws Exception {
  XWPFDocument document = new XWPFDocument();
  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The content");
  clearDocxMetadata(document);

  ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
  document.write(byteOut);
  byteOut.flush();
  byte[] zipData = byteOut.toByteArray();

  zipData = clearZIPEntryLastModified(zipData);

  return zipData;
 }

 static byte[] clearZIPEntryLastModified(byte[] zipData) throws Exception {
  File tmpZipFile = File.createTempFile("zip", ".tmp");
  tmpZipFile.deleteOnExit();

  FileOutputStream fileOut = new FileOutputStream(tmpZipFile);
  fileOut.write(zipData);
  fileOut.close();

  ZipFile zipFile = new ZipFile(tmpZipFile);
  ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
  ZipOutputStream zipOut = new ZipOutputStream(byteOut);
  for(Enumeration enumeration = zipFile.entries(); enumeration.hasMoreElements(); ) {
   ZipEntry entry = (ZipEntry) enumeration.nextElement();
   entry.setTime(new GregorianCalendar(2019,7,14,21,0,0).getTime().getTime());
   zipOut.putNextEntry(entry);
   InputStream is = zipFile.getInputStream(entry);
   byte[] buf = new byte[1024]; int len;
   while ((len = (is.read(buf))) > 0) {
    zipOut.write(buf, 0, (len < buf.length) ? len : buf.length);
   }
   zipOut.closeEntry();
  }
  zipFile.close();
  zipOut.close();
  byteOut.flush();

  return byteOut.toByteArray();
 }

 static void clearDocxMetadata(XWPFDocument document) throws Exception {
  CoreProperties props = document.getProperties().getCoreProperties();
  props.setCreated("2019-08-14T21:00:00z");
  props.setLastModifiedByUser("");
  props.setCreator("");
  props.setLastPrinted("2019-08-14T21:00:00z");
  props.setModified("2019-08-14T21:00:00z");
  document.getProperties().commit();
 }

 public static void main(String[] args) throws Exception {
  byte[] bytes1 = createXWPFZIPArchive();
  Thread.sleep(5000);
  byte[] bytes2 = createXWPFZIPArchive();
  for (int i = 0; i < bytes1.length; i++) {
   byte b1 = bytes1[i];
   byte b2 = 0;
   if (i < bytes2.length) b2 = bytes2[i];
   String sb1 = String.format("%02x", b1);
   String sb2 = String.format("%02x", b2);
   String att = "";if (b1 != b2) att="!";
   if (i == 0 || i % 8 != 0) {
    System.out.print(att+sb1+":"+sb2+"\t");
   } else {
    System.out.println();
    System.out.print(att+sb1+":"+sb2+"\t");
   }
  }
  System.out.println();

  FileOutputStream fileOut = new FileOutputStream("Word1.docx");
  fileOut.write(bytes1);
  fileOut.close();

  fileOut = new FileOutputStream("Word2.docx");
  fileOut.write(bytes2);
  fileOut.close();

 }
}