String website = "http://SOME_WEB_PAGE.com";

// proxy object
BrowserMobProxy proxy = new BrowserMobProxyServer();

// create an response filter
proxy.addResponseFilter(new ResponseFilter() {
    @Override
    public void filterResponse(HttpResponse response, HttpMessageContents contents, HttpMessageInfo messageInfo) {
        // if this is a response to the webpage request
        if(messageInfo.getUrl().equals(website)){
            // parse result with JSOUP and delete all <SCRIPT> Tags
            Document doc = Jsoup.parse(contents.getTextContents());                     
            for(Element e : doc.select("script")) e.remove();                       
            contents.setTextContents(doc.html());
        }
    }
});

// start the proxy and put in as firefox option
proxy.start(0);
Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);            
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.PROXY, seleniumProxy);
FirefoxOptions op = new FirefoxOptions();
op.merge(dc);

// start the selenium web driver and open webpage that should not have any <SCRIPT> Tags now
WebDriver driver = new FirefoxDriver(op);                       
driver.get(website);            
driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

// inject your own javaScript
((JavascriptExecutor) driver).executeScript(
    "var newScript = document.createElement(\"SCRIPT\");" +
    "newScript.innerHTML = \"document.getElementById('time').innerHTML = 'NEW SCRIPT IS RUNNING';\";" +             
    "document.body.appendChild(newScript);");