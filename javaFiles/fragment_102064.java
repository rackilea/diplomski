String JS_GET_SCROLL_HEIGHT = "return Math.max(document.documentElement.scrollHeight, document.body.scrollHeight) | 0;";
String JS_SCROLL_BOTTOM = "window.scroll(0, -1 >>> 1);";

// get the current scroll height
Object scrollHeight = driver.executeScript(JS_GET_SCROLL_HEIGHT);

// set the size of the window
driver.manage().window().setSize(new Dimension(width, height));

// wait for the scroll height to change
new WebDriverWait(driver, 10)
  .until(drv -> !drv.executeScript(JS_GET_SCROLL_HEIGHT).equals(scrollHeight));

// scroll to the bottom
driver.executeScript(JS_SCROLL_BOTTOM);