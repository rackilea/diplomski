public void selectFromDropdown(By dropdownLocator, String optionToChoose) {
    if(this.getName() == BrowserName.EDGE){
        getElementWhenPresent(dropdownLocator).sendKeys(optionToChoose);

    } else {
        Select select = new Select(getElementWhenPresent(dropdownLocator));
        select.selectByVisibleText(optionToChoose);
    }
}