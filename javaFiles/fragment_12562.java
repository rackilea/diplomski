List<WebElement> fullNames   = driver.findElements(By.xpath("//div[@id='content_head_folge']/h1"));
List<WebElement> professions = driver.findElements(By.xpath("//div[@id='content_head_folge']/p"));
List<WebElement> streets     = driver.findElements(By.xpath("//div[@id='content_head_folge']/p/br[1]"));

//2811 results
for (int i = 0; i < 2811; i++)
    resultList.add(new Person(fullNames.get(i).getText(), professions.get(i).getText(), streets.get(i).getText(), null, null, null, null, null));