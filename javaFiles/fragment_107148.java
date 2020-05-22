try {
     WebElement element = driver.findElement(By.xpath("//*[@id='myClass']/tr[1]"));
    //passed
} catch (NoSuchElementException ex) {
    //failed
}