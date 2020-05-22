try 
 {
     String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
     ((JavascriptExecutor) driver).executeScript(mouseOverScript,uploadFileInputFieldWebElement);
     Thread.sleep(1000);
     invalidLicenseFileTypeMessag = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;",tooltipWebElement);


} catch (Exception e) {
    exception message;

}