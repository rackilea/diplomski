List<WebElement> elems = driver.findElements(By.cssSelector("#myElement"));
if (elems.size == 0) {
        System.out.println("My element was not found on the page");
} else
        System.out.println("My element was found on the page");
}