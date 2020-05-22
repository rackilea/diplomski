driver.get("http://www.supremenewyork.com/shop/");
            List<WebElement> allElements = driver.findElements(By.cssSelector("ul#shop-scroller"));
   WebElement ul = allElements.get(0);

   // getting ul data
   System.out.println("ul id = " + ul.getAttribute("id"));
   System.out.println("ul style = " + ul.getAttribute("style"));
   System.out.println("inner html: ");
   System.out.println(ul.getAttribute("innerHTML"));


   // getting all li in ul
   List<WebElement> liList = ul.findElements(By.tagName("li"));
   for(WebElement li: liList) {
       System.out.println("li class = " + li.getAttribute("class"));
       System.out.println("li style = " + li.getAttribute("style"));
       System.out.println("inner html: ");
       System.out.println(li.getAttribute("innerHTML"));
       System.out.println("---------");
      // getting the image  in li
     List<WebElement> imgList = li.findElements(By.tagName("img"));
        WebElement img = imgList.get(0);                
       // do something