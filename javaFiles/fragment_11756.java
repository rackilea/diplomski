public static void deleteSelectedCategory()
{
    driver.findElement(By.cssSelector("#tdb4 > span.ui-button-text")).click();
}

public static void editSelectedCategory()
{
    driver.findElement(By.cssSelector("#tdb3 > span.ui-button-text")).click();
}

public static boolean isProductInStock(String productName)
{
    return !driver.findElements(By.xpath("//tr[./td[@class='dataTableContent'][contains(.,'" + productName + "')]]//img[@src='images/icon_status_green.gif']")).isEmpty();
}

public static void login(String username, String password)
{
    driver.findElement(By.name("username")).sendKeys(username);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.id("tdb1")).click();
}

public static void selectCategory(String categoryName)
{
    driver.findElement(By.xpath("//a[.='Categories/Products']")).click();
    driver.findElement(By.xpath("//td[@class='dataTableContent'][contains(.,'" + categoryName + "')]")).click();
}