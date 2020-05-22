//get the number of items that are required
int size = driver.findElements(By.cssSelector("table#mytable>tbody>tr>td[4]/input")).size();

//now work with each one individually, rather than with a list
for(int i = 1; i <= size; i++) {
    String locator = String.format("table#mytable>tbody>tr[%d]>td[4]/input", i);
    WebElement inputField = driver.findElement(By.cssSelector(locator));
    //get or set the value of the input element
    System.out.println(inputField.getAttribute("value"));
}