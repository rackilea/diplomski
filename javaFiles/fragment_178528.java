import org.apache.poi.hssf.eventusermodel.*;
import org.apache.poi.hssf.record.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.InputStream;
import java.io.FileInputStream;

import java.util.Map;
import java.util.HashMap;

public class EventExample implements HSSFListener {

 private SSTRecord sstrec;
 private Map<Integer, TextObjectRecord> cellCommentRecs = new HashMap<Integer, TextObjectRecord>();
 private int commentORecId = -1;

 public void processRecord(Record record) {

  switch (record.getSid()) {
   case SSTRecord.sid: // shared strings table
    sstrec = (SSTRecord) record;
    break;
   case BoundSheetRecord.sid:
    BoundSheetRecord bsr = (BoundSheetRecord) record;
    System.out.println("Sheet found named " + bsr.getSheetname());
   break;
   case NumberRecord.sid: // numeric cell
    NumberRecord numrec = (NumberRecord) record;
    System.out.println("Cell found with value " + numrec.getValue() + " at row " + numrec.getRow() + " and column " + numrec.getColumn());
    break;
   case LabelSSTRecord.sid: // string cell
    LabelSSTRecord lrec = (LabelSSTRecord) record;
    System.out.println("String cell found with value " + sstrec.getString(lrec.getSSTIndex()) + " at row " + lrec.getRow() + " and column " + lrec.getColumn());
    break;

   case ObjRecord.sid: // object record (https://docs.microsoft.com/en-us/openspecs/office_file_formats/ms-xls/dd34df60-8250-40a9-83a3-911476a31ea7)
    ObjRecord orec = (ObjRecord) record;
    for (SubRecord subrec : orec.getSubRecords()) {
     if (subrec instanceof CommonObjectDataSubRecord) { // kind of shape (https://docs.microsoft.com/en-us/openspecs/office_file_formats/ms-xls/29161566-5018-4356-8d25-50e6674c66fa)
      CommonObjectDataSubRecord codsrec = (CommonObjectDataSubRecord) subrec; 
      if (codsrec.getObjectType() == CommonObjectDataSubRecord.OBJECT_TYPE_COMMENT) { // comment shape
       //System.out.println(codsrec); //FtCmo
       commentORecId = codsrec.getObjectId(); // we have a comment object record, so get it's Id
      }
     } 
    }
    break;

   case TextObjectRecord.sid: // text object (https://docs.microsoft.com/en-us/openspecs/office_file_formats/ms-xls/638c08e6-2942-4783-b71b-144ccf758fc7)
    TextObjectRecord trec = (TextObjectRecord) record;
    //System.out.println(trec); //TxO
    if (commentORecId > -1) { // if we have a a comment object record Id already, so this is a comment text object
     cellCommentRecs.put(commentORecId, trec); // map that Id to the text object record
     commentORecId = -1;
    }
    break;

   case NoteRecord.sid: // note record (https://docs.microsoft.com/en-us/openspecs/office_file_formats/ms-xls/3a610bb3-9d35-435f-92ef-cdbc42974404)
    NoteRecord nrec = (NoteRecord) record; // shapeId points to the comment shape which is immediately followed by the comment text object
    System.out.println("Cell comment found at row " + nrec.getRow() + " and column " + nrec.getColumn() + 
                       ", author: " + nrec.getAuthor() + ", shape-id: " + nrec.getShapeId() +
                       ", comment content: " + cellCommentRecs.get(nrec.getShapeId()).getStr().getString());
    break;

   default:
    //System.out.println(record);
    break;
  }
 }

 public static void main(String[] args) throws Exception {

  //FileInputStream fin = new FileInputStream(args[0]);
  FileInputStream fin = new FileInputStream("./Excel.xls");
  POIFSFileSystem poifs = new POIFSFileSystem(fin);
  InputStream din = poifs.createDocumentInputStream("Workbook");
  HSSFRequest req = new HSSFRequest();
  req.addListenerForAllRecords(new EventExample());
  HSSFEventFactory factory = new HSSFEventFactory();
  factory.processEvents(req, din);
  fin.close();
  din.close();
  System.out.println("done.");
 }
}