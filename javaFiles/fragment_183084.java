public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
    byte[] archive = new byte[0];
    try {
        archive = downloadCssAndImages(getWebClient(), (HtmlPage) getCurrentWindow().getEnclosedPage());
    } catch (Exception e) {
    }
    return (X) archive;
}