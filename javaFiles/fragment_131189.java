// following your logic
WebDriver driver = new HtmlUnitDriver();
List<WebElement> forms = driver.findElements(By.cssSelector("form"));
for (WebElement form : forms) { 
   if (form.getCssValue("display") == "none") break;
   // or if (form.getAttribute("style").contains("display: none")) break;
   System.out.print(form.ToString() + "\n");
}

// a version showing more info
WebDriver driver = new HtmlUnitDriver();
List<WebElement> forms = driver.findElements(By.cssSelector("form"));
for (WebElement form : forms) {
   System.out.print(form.ToString() + "\n");
   System.out.print(form.isDisplayed() + "\n"); // how selenium determines
   System.out.print(form.getCssValue("display") + "\n"); // get css display value
   System.out.print(form.getAttribute("style") + "\n"); // get all style values if exists
   System.out.print("==================\n");
}