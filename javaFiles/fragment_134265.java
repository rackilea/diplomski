public void switchBetweenTabs(int tabIndex)
{
    ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());

    driver.switchTo().window(tabs.get(tabIndex));
}