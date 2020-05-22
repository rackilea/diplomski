public <T extends BasePage> Optional<T> clickSubMenuItem(MenuBar menuBar) {
    int hoveredMenuItemIndex =mouseOverToMenuItemByTitle(menuBar.menuOptionTitle);
    if (hoveredMenuItemIndex > -1) {
        allSubMenuItem = getWebElements(By.cssSelector("#topnav > .rootmenu > li:nth-child(" + hoveredMenuItemIndex + ") > ul > li > a"));
        for (WebElement subMenuItem : allSubMenuItem) {
            if (subMenuItem.getAttribute("title").contains(menuBar.subMenuTitle)) {
                subMenuItem.click();
                return Optional.of(instantiatePageClass((Class<T>) menuBar.expectedPageClass));
            }
        }
    }
    return Optional.empty();
}