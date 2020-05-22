final WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
    webClient.getOptions().setJavaScriptEnabled(false);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setCssEnabled(false);
    webClient.getOptions().setRedirectEnabled(true);
    java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
    final HtmlPage page1 = webClient.getPage("https://login.yahoo.com/account/create?specId=yidReg&lang=en-JO&src=ym&done=https%3A%2F%2Fmail.yahoo.com&display=login&intl=xa");