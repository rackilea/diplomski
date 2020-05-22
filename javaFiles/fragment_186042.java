public static void WaitForCommission (WebDriver driver) throws Exception {
    for (int second = 0; second++) {
        if (second >= 30) fail("timeout");
        try { 
            if (IsElementActive(By.id("someElementID"), driver)) 
                break; 
            } catch (Exception e) {}
        Thread.sleep(1000);
    }
}

private static boolean IsElementActive(By id, WebDriver driver) {
    WebElement we =  driver.findElement(id);        
    if(we.isEnabled())
        return true;
    return false;
}