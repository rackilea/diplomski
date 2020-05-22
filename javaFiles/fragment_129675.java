Integer port = 4444;
String browserString= "*firefox";
String url = "http://yoururl.com";
selenium = new DefaultSelenium("localhost",port,browserString,url) {
public void open(String url) { commandProcessor.doCommand("open", new String[] {url,"true"});};
selenium.start();