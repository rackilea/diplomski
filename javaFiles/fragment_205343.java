List<WebElement> menuList = driver.findElementsByClassName("no.ruter.reise.qa:id/label");
int listSize = menuList.size();
int index = 0;
Boolean menuFound = false;
for(WebElement menu : menuList)
{
    String label = menu.getText();
    System.out.printf("%d of, %s\n", index,label);
    if (label.equals(menuItem)){
        menu.click();
        System.out.printf("\t%s %s\n", menuItem, "click");
        menuFound = true;
    }
    index++;
}