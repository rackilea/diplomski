static WebElement getTableLink(WebElement table, String column, int row) {
    JavascriptExecutor js = (JavascriptExecutor)((RemoteWebElement)table).getWrappedDriver();

    WebElement link = (WebElement)js.executeScript(
        "var rows = arguments[0].rows, header = arguments[1], iRow = arguments[2];      " +
        "var iCol = [].findIndex.call(rows[0].cells, (td) => td.textContent == header); " +
        "return rows[iRow].cells[iCol].querySelector('a');                              " ,
        table, column, row);

    return link;
}