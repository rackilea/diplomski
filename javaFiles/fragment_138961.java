//Get Page
HtmlPage page1 = webClient.getPage("https://login-url/");

//Wait for background Javascript
webClient.waitForBackgroundJavaScript(10000);

//Get full page _after_ javascript has rendered it fully
System.out.println(page1.asXml());