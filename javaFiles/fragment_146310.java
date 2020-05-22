List<WebElement> x = driver.findElements(By.xpath("//button[contains(@title,'Dismiss notification')]"));

if (x.size() > 0)
{
    x.get(0).click();
}
// else element is not found.