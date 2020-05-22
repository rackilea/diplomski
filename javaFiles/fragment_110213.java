List<WebElement> rows = driver.findelements(By.xpath('//table[@class="cornelius-table"]//tr[not(th)]'));
Iterator<WebElement> iter = rows.iterator();
while(iter.hasNext()) {
    WebElement tr = iter.next();
    td = tr.findelement(By.xpath('./td[not(@class="cornelius-empty")][last()]'));
    System.out.println(td.getText());
    }
}