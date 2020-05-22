private static final Logger LOGGER = Logger.getLogger([className].class.getName());

public static void clickOnElement(By by){ 
try {
     WebElement element = driver.findElement(by).click();
    } catch (NoSuchElementException e) {
        LOGGER.log(Level.WARNING, e.getMessage(), e);   
    }
}