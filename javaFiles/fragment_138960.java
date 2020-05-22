WebClient webClient = new WebClient(BrowserVersion.FIREFOX_17);
webClient.getOptions().setRedirectEnabled(true);
webClient.getOptions().setCssEnabled(false);
webClient.getOptions().setThrowExceptionOnScriptError(false);
webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
webClient.getOptions().setUseInsecureSSL(true);
webClient.getOptions().setJavaScriptEnabled(true);
webClient.getCookieManager().setCookiesEnabled(true);