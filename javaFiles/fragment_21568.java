import org.openqa.selenium.Keys;

String barcode="0000000047166";
WebElement element_enter = driver.findElement(By.xpath("//*[@id='div-barcode']"));
element_enter.findElement(By.xpath("your xpath")).sendKeys(barcode);

element_enter.sendKeys(Keys.RETURN); // this will result in the return key being pressed upon the text field