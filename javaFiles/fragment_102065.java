String JS_GET_INNER_HEIGHT = "return window.innerHeight | 0;";
String JS_SCROLL_BOTTOM = "window.scroll(0, -1 >>> 1);";

// get the current scroll height
Object innerHeight = driver.executeScript(JS_GET_INNER_HEIGHT);

// set the size of the window
driver.manage().window().setSize(new Dimension(width, height));

// wait for the scroll height to change
new WebDriverWait(driver, 10)
  .until(drv -> !drv.executeScript(JS_GET_INNER_HEIGHT).equals(innerHeight));

// scroll to the bottom
driver.executeScript(JS_SCROLL_BOTTOM);