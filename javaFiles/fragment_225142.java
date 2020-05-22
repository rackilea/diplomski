//year is the user input value
String xp = "//span[text()='" + year + "']/ancestor::div[contains(@id, 'PagePostsSectionPagelet')]//div[@class='_5sem']";

WebElement comment = driver.findElement(By.xpath(xp)); 
// Add code to fetch 'UFIPagerLink' and 'UFIPagerIcon'
// which should be inside the div tag with class="_5sem"