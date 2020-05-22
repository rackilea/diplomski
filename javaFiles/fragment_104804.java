System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\Selenium\\chromedriver.exe");

  WebDriver driver = new ChromeDriver();

  driver.manage().window().maximize();


  driver.get("http://www.globalsqa.com/demo-site/accordion-and-tabs/#Re-Size Accordion");

  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

  Thread.sleep(10000);


 /* //Goto header frame

  WebElement headerFrame = driver.findElement(By.xpath("/html/body/div[1]/iframe"));

  driver.switchTo().frame(headerFrame);




  //click close icon on header frame

  driver.findElement(By.xpath("//*[@id='close-icon']")).click();

  //Switch back to initial frame
  driver.switchTo().defaultContent();
  */


  //Switch to new frame containing Accordion controls
  WebElement myFrame = driver.findElement(By.cssSelector("#post-2654 > div.twelve.columns > div.newtabs.horizontal > div > div.single_tab_div.resp-tab-content.resp-tab-content-active > p:nth-child(2) > iframe"));

  driver.switchTo().frame(myFrame);

  Actions action = new Actions(driver);


  //element to be streched
  WebElement from = driver.findElement(By.cssSelector("div#accordion+div"));


  System.out.println(from.getText());

  Thread.sleep(10000);
  action.clickAndHold(from).moveByOffset(50,10).release(from).build().perform();

  JavascriptExecutor js = (JavascriptExecutor) driver;

  js.executeScript("document.getElementById('accordion-resizer').setAttribute('style', 'width: 700px; height: 400px;')");