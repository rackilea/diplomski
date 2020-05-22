public void searchForEmployee(String text) {
    WebElement results = getDriver().findElement(By.className("fn"));
    if (inputFieldIsEmpty(search)) {
        search.sendKeys(text);
    }
    wait.until(ExpectedConditions.stalenessOf(results));
}

public boolean listOfEmployeeCards(String employee) {
    List<String> employeeList = elementToStringList(employees);
    return elementListContainsString(employeeList, employee);
}