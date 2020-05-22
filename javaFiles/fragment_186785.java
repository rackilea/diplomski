List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
if(iframes.size() == 0) {
    Assert.fail();       
} else {
    // Frames present    
    Assert.assertTrue(true);
}