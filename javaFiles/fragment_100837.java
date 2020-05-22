public void getText()  {
    WebDriverWait wait=new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mid']/div")));
    WebElement result=driver.findElement(By.id("mid"));
    System.out.println(result.getText());
}