Select sel = new   Select(driver.findElement(By.cssSelector("select[title='Sort By']")));

List<WebElement> list = sel.getOptions();

for(int i=0;i<list.size();i++){
  if(list.get(i).getText().equals("Price")){
    System.out.println("The index of the selected option is: "+i);
    break;
      }
}