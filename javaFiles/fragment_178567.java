WebDriver driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get("http://connectatgrace.org/im-new/what-to-expect");
WebElement content = driver.findElement(By.id("content full-width"));
Actions builder = new Actions(driver);
builder.moveToElement(content, content.getSize().getWidth() / 2, content.getSize().getWidth() / 2).clickAndHold().moveToElement(content, -content.getSize().getHeight() / 2, -content.getSize().getHeight() / 2);
builder.build().perform();