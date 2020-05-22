System.setProperty("webdriver.gecko.driver", "C:\\your_directory\\geckodriver.exe");
    WebDriver dr=new FirefoxDriver();
    dr.get("https://jqueryui.com/selectmenu/");
    dr.manage().window().maximize();
    dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    dr.switchTo().frame(dr.findElement(By.className("demo-frame")));
    dr.findElement(By.xpath("//*[@id='speed-button']/span[@class='ui-selectmenu-text']")).click();