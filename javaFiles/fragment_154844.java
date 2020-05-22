WebElement subjectElems = driver.findElement(By.xpath("//*[@id=\"subjects-list\"]"));


 List<WebElement> linkList =  subjectElems.findElements(By.tagName("a"));

       for(WebElement link: linkList) {
             System.out.println(link.getText());
             link.click();
       }