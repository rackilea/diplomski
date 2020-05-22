List<WebElement> eles = driver.findElements(By.cssSelector("ul.rcbList > li"));

List<String> txts = new ArrayList<String>();
String script = "return arguments[0].lastChild.nodeValue;";
JavascriptExecutor js = (JavascriptExecutor) driver;
int length = eles.size();

for(int i=0;i<length;i++) {
    WebElement ele = eles.get(i);
    String text = (String) js.executeScript(script, ele);
    if(text.equals(sheetValue)) {
       ele.findElement(By.cssSelector('input')).click();
       txts.add(text);
       // find all li again on page after click,
       // seems each click on checkbox caused page DOM tree changed
       eles = driver.findElements(By.cssSelector("ul.rcbList > li"));
    }

}