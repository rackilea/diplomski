// Blocks current thread execution and waits until the web page is loaded completely
Browser.invokeAndWaitFinishLoadingMainFrame(browser, new Callback<Browser>() {
    @Override
    public void invoke(Browser value) {
        value.loadHTML("<html><body>Your HTML goes here</body></html>");
    }
});