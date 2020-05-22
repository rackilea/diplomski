List<WebElement> allrates = driver.findElements(By.xpath("//div[@class='author medium-3 small-12 column padding-reset tip-list-row__author']/a//abbr"));
List<WebElement> allusers = driver.findElements(By.xpath("//div[@class='author-name']/a"));
for (int i = 0; i < alltips; i++) 
{
    String all = allrates.get(i).getAttribute("title");
    String users = allusers.get(i).getText();
    System.out.println("User " + users + " has a rate " + all);
}