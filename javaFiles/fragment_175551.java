System.setProperty("webdriver.chrome.driver","Your driver path");
WebDriver  driver = new ChromeDriver( );
driver.manage().window().maximize();
driver.get("http://babysden.demo2clients.com/customer/account/login/referer/aHR0cDovL2JhYnlzZGVuLmRlbW8yY2xpZW50cy5jb20vP19fX1NJRD1V/");

//Locate element email and send values 
driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");

////Locate element Password and send values 
driver.findElement(By.id("pass")).sendKeys("xxxxxxx");

//click on send
driver.findElement(By.id("send2")).click();