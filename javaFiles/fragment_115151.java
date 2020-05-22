@DataProvider
public  Object[][] getData(ITestNGMethod testContext)
{
    String excelPath = "src/main/java/apps/teamo/testdata/Book 1.xlsx";
    if(testContext.getMethodName().equals("testSheetA"))
    {
        return testData(excelPath, "sheetA");
    }
    else if(testContext.getMethodName().equals("testSheetB"))
    {

        return testData(excelPath, "sheetB");
    }
    .....

}