List<WebElement> fullNames   = driver.findElements(By.xpath("//div[@id='content_head_folge']/h1"));
List<WebElement> professions = driver.findElements(By.xpath("//div[@id='content_head_folge']/p"));
List<WebElement> streets     = driver.findElements(By.xpath("//div[@id='content_head_folge']/p/br[1]"));

if( fullNames.size() != professions.size() || fullNames.size() != streets.size() ){
    throw new IllegalStateException( "can't get the data" );
}