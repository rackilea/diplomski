public void aa() throws InterruptedException {

String script = 
        "var head= document.getElementsByTagName('head')[0];" +
        "var script= document.createElement('script');" +
        "script.type= 'text/javascript';" +
        "script.src= 'test.js';" +
        "head.appendChild(script);";

driver.get("file:///C:/workspace/js-projects/tey/reports/cucumber_report.html");
Thread.sleep(3000);

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript(script);

Thread.sleep(3000);
js.executeScript("test()");

Thread.sleep(10000);
}