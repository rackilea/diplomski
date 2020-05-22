@When("^I populate a field with a new value$")
    public void ShouldPopulateFieldsWithValues(DataTable dataTable) throws Throwable {
        List<List<String>> rows = dataTable.asLists(String.class);
        // Either quit having a header in your datatable or remove the first row
        rows.remove(0);
        for (List<String> row : rows) {
            String fieldName = row.get(0);
            String fieldValue = row.get(1);

            // Use the IDs as name in your datatable
            WebElement profileNameTextbox = webdriver.findElement(By.id(fieldName));
            profileNameTextbox.clear();
            profileNameTextbox.sendKeys(fieldValue);
        }
    }