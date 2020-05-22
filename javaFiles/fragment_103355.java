BrowserWindowOpener opener =
    new BrowserWindowOpener(url);
opener.setParameter("parameter","value");

Button button = new Button("Press me");
opener.extend(button);