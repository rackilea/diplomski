driver.get("http://the-internet.herokuapp.com/dynamic_content");

List<WebElement> images = driver.findElements(By.cssSelector("img"));
for (int i = 1; i < images.size(); i++)
{
    System.out.println(getHashOfImage(new URL(images.get(i).getAttribute("src"))));
}