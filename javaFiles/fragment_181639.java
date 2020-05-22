WebElement image = driver.findElement(By.xpath("//td/img[@src='http://m.com/en/images/common/green_check.png']"));

if(image.isDisplayed())
{
    System.out.println("Image is present on the page.");
}
else
{
    System.out.println("Image is not present on the page.");
}