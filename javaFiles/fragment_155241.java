import javax.inject.Provider;

static class MyFirefoxProvider implements Provider<EmbeddedBrowser> {

    @Override
    public EmbeddedBrowser get() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", "/tmp");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
            "application/octet-stream,application/pdf,application/x-gzip");

        // disable Firefox's built-in PDF viewer
        profile.setPreference("pdfjs.disabled", true);
        // disable Adobe Acrobat PDF preview plugin
        profile.setPreference("plugin.scan.plid.all", false);
        profile.setPreference("plugin.scan.Acrobat", "99.0");

        FirefoxDriver driver = new FirefoxDriver(profile);

        return WebDriverBackedEmbeddedBrowser.withDriver(driver);
    }
}