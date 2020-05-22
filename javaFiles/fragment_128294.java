try{
        WebElement byId = driver.findElement(By.id("by-id"));

        System.out.println(byId.getTagName());

        System.out.println("get the text for web element with id='by-id' ");
        System.out.println("------------------------------------------------------------");
        System.out.println(byId.getText());
        System.out.println("------------------------------------------------------------");
        System.out.println(byId.getAttribute("id"));
        System.out.println(byId.getCssValue("font-size"));
    }
}