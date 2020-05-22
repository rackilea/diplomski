List<WebElement> allImagesUnderThisClass = driver.findElements(By.className("butik-large-image"));
    String ignoreImageURl = "https://www.trendyol.com/Resources/images/bigBoutiquePlaceHolder.png";
    for(WebElement elem : allImagesUnderThisClass){
        List<WebElement> imgs = elem.findElements(By.tagName("img"));
        for(WebElement img : imgs){
            String source = img.getAttribute("src");
            if(!source.equalsIgnoreCase(ignoreImageURl)){
                System.out.println(source); 
            }
        }   
    }