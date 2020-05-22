import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestclassSample {

  private Map<String, String> data;
  private static final String SHEET = "sheet";
  private static final String FILENAME = "filename";

  @Factory(dataProvider = "dp")
  public TestclassSample(Map<String, String> data) {
    this.data = data;
  }

  @Test
  public void dataIsNotEmpty() {
    System.err.println("Ensuring that " + data + " is not empty");
    Assert.assertFalse(data.isEmpty());
  }

  @Test
  public void dataHasAtleastTwoColumns() {
    System.err.println("Ensuring that " + data + " has atleast 2 entries");
    Assert.assertTrue(data.size() >= 2);
  }

  @DataProvider(name = "dp")
  public static Object[][] getData(ITestContext context)
      throws IOException, InvalidFormatException {
    String filename = context.getCurrentXmlTest().getParameter(FILENAME);
    if (filename == null || filename.trim().isEmpty()) {
      throw new IllegalArgumentException("File name was not present as a parameter");
    }
    Workbook workbook = WorkbookFactory.create(new File(filename));
    String sheet = context.getCurrentXmlTest().getParameter(SHEET);
    if (sheet == null || sheet.trim().isEmpty()) {
      throw new IllegalArgumentException("Sheet name was not present as a parameter");
    }
    Sheet worksheet = workbook.getSheet(sheet);
    DataFormatter dataFormatter = new DataFormatter();
    Row headingRow = worksheet.getRow(0);
    List<String> heading = new ArrayList<>();
    for (Cell cell : headingRow) {
      heading.add(dataFormatter.formatCellValue(cell));
    }
    List<Map<String, String>> information = new ArrayList<>();
    for (int i = 1; i < worksheet.getLastRowNum(); i++) {
      Map<String, String> data = new HashMap<>();
      int index = 0;
      for (Cell cell : worksheet.getRow(i)) {
        data.put(heading.get(index++), dataFormatter.formatCellValue(cell));
      }
      information.add(data);
    }

    Object[][] data = new Object[information.size()][1];
    for (int i = 0; i < information.size(); i++) {
      data[i] = new Object[] {information.get(i)};
    }
    workbook.close();
    return data;
  }
}