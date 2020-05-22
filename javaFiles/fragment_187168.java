// disable the click event on an `<input>` file
((JavascriptExecutor)driver).executeScript(
    "HTMLInputElement.prototype.click = function() {                     " +
    "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
    "};                                                                  " );

// trigger the upload
driver.findElement(By.id("Dialogs_Dialogs_lbAttachUpload"))
      .click();

// assign the file to the `<input>`
driver.findElement(By.cssSelector("input[type=file]"))
      .sendKeys("filepath\\Test PDF.pdf");