public void testRowSelectionUsingControlKey() {
        List tableRows = driver.findElements(By.xpath("//table[@class='iceDatTbl']/tbody/tr"));
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
               .click(tableRows.get(0))
               .click(tableRows.get(1))
               .click(tableRows.get(2))
               .click(tableRows.get(3))
               .click(tableRows.get(4))
               .keyUp(Keys.CONTROL).build().perform();
        }