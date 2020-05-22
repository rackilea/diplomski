public void openSubMenu(String menu) throws InterruptedException{


       //mouse over on Main menu 'Departments'
        WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-shopall']"));

        Actions action = new Actions(driver);

        action.moveToElement(element).build().perform();
        Thread.sleep(5000L);

        //verify sub menus are listed or not
        WebElement dropDown = driver.findElement(By.cssSelector("#nav-flyout-shopAll"));

        if (dropDown.isDisplayed()) {
            System.out.println("pass");

        } else {

            Assert.fail();
        }

        //
        WebElement subMenu1 = driver.findElement(By.cssSelector("#nav-flyout-shopAll > div.nav-tpl-itemList>span:nth-child(1)"));
        WebElement subMenuWantedToOpen = driver.findElement(By.cssSelector("#nav-flyout-shopAll > div.nav-tpl-itemList>span[aria-label='"+menu.trim()+"']"));

        action.moveToElement(subMenu1).moveToElement(subMenuWantedToOpen).build().perform();

        Thread.sleep(5000L);

        WebElement subMenuCat = driver.findElement(By.cssSelector(".nav-subcats > div.nav-subcat[style='display: block;']"));

        if(subMenuCat.isDisplayed()){
            System.out.println(subMenuCat.getText());
        }

}