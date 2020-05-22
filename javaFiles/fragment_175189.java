System.setProperty("webdriver.chrome.driver", "C:\\Users\\me\\Downloads\\chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
JavascriptExecutor executor = (JavascriptExecutor) driver;
String js = "function test() {" +
            "arr = 111; return arr;" +
            "}; return test()";
Long a = (Long) executor.executeScript(js);
System.out.println(a);