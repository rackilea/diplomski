import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableHyperlink;
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
    String formulaText ="HYPERLINK(CONCATENATE(Overview$B$15,\"users\",C2),\"Link\")";
    String[] linkBits = formulaText.substring(formulaText.lastIndexOf("(")+1,formulaText.indexOf(")")).split(",");
    String baseURL = "http://www.stackoverflow.com/";
    String linkURL = baseURL+linkBits[1].replace("\"","")+"/"+sheet.getCell(linkBits[2]).getContents();
    String linkDesc = "Profile";
    WritableHyperlink link = new WritableHyperlink(1, 1, new URL(linkURL));
    link.setDescription(linkDesc);
    sheet.addHyperlink(link);

    //Writes out the data held in this workbook in Excel format
    workbook.write(); 

    //Close and free allocated memory 
    workbook.close(); 
  }

}