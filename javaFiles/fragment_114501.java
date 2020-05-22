import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Test {


    String element;
    static String storedElement[][] = null;
    static String Element[][] = null;


    public static void main(final String[] args) throws BiffException, IOException, RowsExceededException, WriteException {


        FileInputStream fs = new FileInputStream("file location(.xls)");
        Workbook wb = Workbook.getWorkbook(fs);
        Sheet sh = wb.getSheet(0);

        Workbook workbook = Workbook.getWorkbook(new File("file location(.xls)"));
        WritableWorkbook ww = Workbook.createWorkbook(new File("file location(.xls)RENAME THE FILE here"),
            workbook);
        WritableSheet ws = ww.getSheet(0);

        Label label = null;


        Test.storedElement = new String[sh.getColumns()][sh.getRows()];
        Test.Element = new String[sh.getColumns()][sh.getRows()];

        int j = 0; // column #0
        int q = 1; // column #1

        for (int i = 1; i < sh.getRows(); i++) {
            Cell cell = sh.getCell(j, i);
            Cell cell1 = sh.getCell(q, i);

            Test.storedElement[j][i] = cell.getContents();
            Test.Element[q][i] = cell1.getContents();
            String elem = Test.storedElement[j][i];
            System.out.println(elem);
            String elem1 = Test.Element[q][i];
            System.out.println(elem1);


            String[] ob = elem1.split("\n");
            String[] ob1 = elem.split("\n");

            String valid = "valid";
            String invalid = "invalid";
            String Status = "";
            if ((ob[0].equals(ob1[0])) && (ob[1].equals(ob1[1]))) {
                Status = valid + "\n" + valid;
            } else if ((!ob[0].equals(ob1[0])) && (ob[1].equals(ob1[1]))) {
                Status = invalid + "\n" + valid;
            } else if ((!ob[0].equals(ob1[0])) && (!ob[1].equals(ob1[1]))) {
                Status = valid + "\n" + invalid;
            } else {
                Status = invalid + "\n" + invalid;
            }

            label = new Label(2, i, Status);
            ws.addCell(label);


        }
        ww.write();
        ww.close();
        workbook.close();
    }
}