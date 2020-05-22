package cellstest;
import com.aspose.cells.Workbook;
public class AsposeCellsUtil 
{
    public String doSomeOpOnWorkbook(String inFile, String outFile)
    {
        String result = "";
        try
        {
            // Load the workbook
            Workbook wb = new Workbook(inFile);
            // Do some operation with this workbook
            // ..................
            // Save the workbook
            wb.save(outFile);
            // everything ok.
            result = "ok";
        }
        catch(Exception ex)
        {
            // Return the exception to calling program
            result = ex.toString();
        }
        return result;
    }
}