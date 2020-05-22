WebElement dropdownElement = findElementHelper(by);

String tempValue = value.trim().toLowerCase();

List<WebElement> matchingValues = dropdownElement.findElements(By.xpath(
        ".//option[lower-case(@value) = '" + tempValue + "']"));    

for(WebElement matchingValue : matchingValues)
{
     /* Do what you want with the options         
     if (!option.isSelected()) {
         option.click();
     } */
}