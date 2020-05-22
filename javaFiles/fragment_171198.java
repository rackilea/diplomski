List<WebElement> elements = (List<WebElement>) ((JavascriptExecutor) driver)
  .executeScript(
    "var elements = document.getElementsByClassName('foo');" + 
    "return Array.prototype.filter.call(elements, function (el) {" + 
    "  return el.attributes.whatever.value === 'something';" +
    "});");