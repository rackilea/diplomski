@BeforeTest
public void setUp1() {
    // where we need to generate the report
    String fileName = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    htmlReporter = new ExtentHtmlReporter("C:/xampp/htdocs/Automation_report/files/summerrentals/summerrentals("+fileName+").html");
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);

    // Set our document title, theme etc..
    htmlReporter.config().setDocumentTitle("Testing");
    htmlReporter.config().setReportName("Testing");
    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    htmlReporter.config().setTheme(Theme.DARK);
}