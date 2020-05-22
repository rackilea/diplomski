public void selectOptionFromDropdownMenu(WebElement dropdown, String textToSearchFor) {
List<WebElement> options = dropdown.findElements(By.tagName("option"));
Select selectDropdown = new Select(dropdown);
//dropdown.click();
System.out.println(options.size());

for (int i = 0; i < options.size(); i++) {
    System.out.println("DEVIL!!!"  + options.get(i).getText());

    if(options.get(i).getText().equals(textToSearchFor)) {
    selectDropdown.selectByVisibleText(textToSearchFor);
        //options.get(i).click();
    }
}