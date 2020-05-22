String urlwyniki ="https://www.oferty.net/mieszkania/szukaj?ps%5Blocation%5D%5Btype%5D=1&ps%5Btype%5D=1&ps%5Btransaction%5D=1&ps%5Blocation%5D%5Btext%5D=dolno%C5%9Bl%C4%85skie";
driver.get(urlwyniki);
String xpathResult = "//table/tbody/tr/td";
List<WebElement> rows = driver.findElements(By.xpath(xpathResult));
List<WebElement> cols=new ArrayList<WebElement>();
for(int i=0;i<rows.size();i++){
    System.out.print("Row value: "+i);
    cols=rows.get(i).findElements(By.tagName("td"));
    for(WebElement col:cols)
        System.out.print("cell value "+col.getText());
}