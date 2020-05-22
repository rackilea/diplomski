// navigate to stackoverflow page
    driver.get("https://stackoverflow.com/");
    /* below is the javascript function that we have to run in the browser console
     * If you look at the starting of the function name declaration in the javascript you see the difference
     * `window.functioName = function(arg)` is the general notation when you 
     * want to make the javscript function available in the browser window
     */

    String jsFunction = "window.isElementInViewport= function(el) {\r\n" + 
            "    var rect = el.getBoundingClientRect();\r\n" + 
            "    return  rect.bottom > 0 &&\r\n" + 
            "            rect.right > 0 &&\r\n" + 
            "            rect.left < (window.innerWidth || document.documentElement.clientWidth) &&\r\n" + 
            "            rect.top < (window.innerHeight || document.documentElement.clientHeight) ;\r\n" + 
            "}";
    // execute the javascript function
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript(jsFunction);

    // Questions Element
    WebElement questionsEle = driver.findElement(By.cssSelector("li.-item a[href='\\/questions']"));

    // check Questions Elements before scrolling
    System.out.println(js.executeScript("return isElementInViewport(arguments[0])", questionsEle));

    // Scroll to element
    js.executeScript("arguments[0].scrollIntoView();", questionsEle);

    // check Questions Elements after scrolling
    System.out.println(js.executeScript("return isElementInViewport(arguments[0])", questionsEle));