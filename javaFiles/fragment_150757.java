@RunWith(Parameterized.class)
public class SampleTest {

  @Parameters(name = "{0}")
  public static List<BranchMailChildSample> data() {
    String excel = "C:\\Resources\\TestData\\ExcelSheets\\BranchMail\\branchmail_TestData.xlsx";
    ExcelMarshallerTool tool = new ExcelMarshallerTool(excel);
    return tool.unmarshallExcel(BranchMailChildSample.class);
  }

  private final BranchMailChildSample branch;

  public SampleTest(BranchMailChildSample branch) {
    this.branch = branch;
  }

  @Test
  public void test() {
    System.out.println(branch.toString());
  }
}