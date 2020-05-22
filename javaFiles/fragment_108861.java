//WebElement source = driver.findElement(By.xpath(".//*[@id='jqxWidgete3128591f541']"));
    WebElement source = driver.findElement(By.xpath("//div[@id='shop']"));
    List<WebElement> listDraggableElement=source.findElements(By.xpath("//div[@class='draggable-demo-product jqx-rc-all jqx-draggable']"));

    WebElement target = driver.findElement(By.xpath(".//*[@id='cart']"));
    Actions actions = new Actions(driver);
    for(WebElement el: listDraggableElement)
    {
        System.out.println(el.getText());
        actions.dragAndDrop(el, target).build().perform();
    }