WaitTool.waitForElementPresent(Browser.instance, By.className("cke_wysiwyg_frame"), 10);
WebElement iframe = Browser.instance.findElement(By.className("cke_wysiwyg_frame"));
Browser.instance.switchTo().frame(iframe);

WebElement description = Browser.instance.findElement(By.cssSelector("body"));
(JavascriptExecutor)Browser.instance.executeScript("arguments[0].innerHTML = '<h1>Set text using innerHTML</h1>'", description);