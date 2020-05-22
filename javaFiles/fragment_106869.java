WebElement element;
String URL;

try {
    element = getDriver().findElement(By.css("body > p:nth-child(5)"));
    URL = element.getText();
} catch (Exception e) {
    String mailBody = getDriver().findElement(By.css("body > p:nth-child(2)")).getText();
    String[] temp = mailBody.split("\n");
    URL = temp[2];
    System.out.println(URL); 
}