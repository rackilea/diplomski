import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.xssf.model.SharedStringsTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

import  org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlException;

import javax.xml.namespace.QName;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.util.regex.Pattern;

class ReadAndWriteTest5 {

 public static void main(String[] args) {
  try {

   File file = new File("ReGesamt11_3Test.xlsx");
   //we only open the OPCPackage, we don't create a Workbook
   OPCPackage opcpackage = OPCPackage.open(file);

   //if there are strings in the SheetData, we need the SharedStringsTable
   PackagePart sharedstringstablepart = opcpackage.getPartsByName(Pattern.compile("/xl/sharedStrings.xml")).get(0);
   SharedStringsTable sharedstringstable = new SharedStringsTable();
   sharedstringstable.readFrom(sharedstringstablepart.getInputStream());

   //create empty WorksheetDocument for the "data source sheet"
   WorksheetDocument worksheetdocument = WorksheetDocument.Factory.newInstance();
   CTWorksheet worksheet = worksheetdocument.addNewWorksheet();
   CTSheetData sheetdata = worksheet.addNewSheetData();

   //put some data in for the "data source sheet"
   for (int i = 0; i < 10; i++) {

    CTCell ctcell= sheetdata.addNewRow().addNewC();

    CTRst ctstr = CTRst.Factory.newInstance();
    ctstr.setT("DataRow " + i);
    int sRef = sharedstringstable.addEntry(ctstr);
    ctcell.setT(STCellType.S);
    ctcell.setV(Integer.toString(sRef));

    ctcell=sheetdata.getRowArray(i).addNewC();
    ctcell.setV(""+(i*100+(i+1)*10+(i+2))+"."+((i+3)*10+(i+4)));

   }

   //write the SharedStringsTable
   OutputStream out = sharedstringstablepart.getOutputStream();
   sharedstringstable.writeTo(out);
   out.close();

   //create XmlOptions for saving the worksheet
   XmlOptions xmlOptions = new XmlOptions();
   xmlOptions.setSaveOuter();
   xmlOptions.setUseDefaultNamespace();
   xmlOptions.setSaveAggressiveNamespaces();
   xmlOptions.setCharacterEncoding("UTF-8");
   xmlOptions.setSaveSyntheticDocumentElement(new QName(CTWorksheet.type.getName().getNamespaceURI(), "worksheet"));
   Map<String, String> map = new HashMap<String, String>();
   map.put(STRelationshipId.type.getName().getNamespaceURI(), "r");
   xmlOptions.setSaveSuggestedPrefixes(map);

   //get the PackagePart of the third sheet which is the "data source sheet" 
   //this sheet must exist and will be replaced with the new content
   PackagePart sheetpart = opcpackage.getPartsByName(Pattern.compile("/xl/worksheets/sheet3.xml")).get(0);
   //save the worksheet as the third sheet which is the "data source sheet" 
   out = sheetpart.getOutputStream();
   worksheet.save(out, xmlOptions);
   out.close();

   //get the PackagePart of the fourth sheet which is the sheet on which formulas are referencing the "data source sheet"
   //since we can't use Evaluator, we must force recalculation on load for this sheet
   sheetpart = opcpackage.getPartsByName(Pattern.compile("/xl/worksheets/sheet4.xml")).get(0);
   worksheetdocument = WorksheetDocument.Factory.parse(sheetpart.getInputStream());
   worksheet = worksheetdocument.getWorksheet();
   //setFullCalcOnLoad true
   if (worksheet.getSheetCalcPr() == null) {
    worksheet.addNewSheetCalcPr().setFullCalcOnLoad(true);
   } else {
    worksheet.getSheetCalcPr().setFullCalcOnLoad(true);
   }
   out = sheetpart.getOutputStream();
   worksheet.save(out, xmlOptions);
   out.close();

   opcpackage.close();

  } catch (InvalidFormatException ifex) {
     ifex.printStackTrace();
  } catch (FileNotFoundException fnfex) {
     fnfex.printStackTrace();
  } catch (IOException ioex) {
     ioex.printStackTrace();
  } catch (XmlException xmlex) {
     xmlex.printStackTrace();
  }
 }
}