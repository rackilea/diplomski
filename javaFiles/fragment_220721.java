import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.CellFormat;
import jxl.Workbook;
import jxl.biff.CellReferenceHelper;
import jxl.biff.DisplayFormat;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Launcher {

  /**
   * @param args
   * @throws IOException 
   * @throws IOException 
   * @throws WriteException 
   * @throws BiffException 
   */
  public static void main(String[] args) throws IOException, WriteException {
    //Creates a writable workbook with the given file name
    WritableWorkbook workbook = Workbook.createWorkbook(new File("D:\\Documents and Settings\\castone\\My Documents\\Formula.xls"));

    WritableSheet sheet = workbook.createSheet("My Sheet", 0);

    ArrayList<Label> labelList = new ArrayList<Label>();
    //create the filler text
    labelList.add(new Label(0, 0, "UnicornName"));
    labelList.add(new Label(0, 1, "Pureferret"));
    labelList.add(new Label(2, 0, "Unicorn ID"));
    labelList.add(new Label(2, 1, "1075247"));
    labelList.add(new Label(1, 0, "Hyperlink"));
    for(Label label:labelList){
        sheet.addCell(label);
    }    
    //Create a formula for adding cells
    String formulaText ="HYPERLINK(CONCATENATE(\"https://stackoverflow.com/users/\","+
            CellReferenceHelper.getCellReference(2, 1).toString()+"),\"Link\"";
    Formula link = new Formula(1, 1,formulaText);
    sheet.addCell(link);

    //Writes out the data held in this workbook in Excel format
    workbook.write(); 

    //Close and free allocated memory 
    workbook.close(); 
  }

}