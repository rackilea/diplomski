interface BrowserStrategy {
    Browser create();
}

public class ChromeBrowser implements BrowserStrategy {
    public Browser create() {
        return new ChromeBrowser();
    }
}

public class BrowserFactor {
    Map<String, BrowserStrategy> ctorStategy = ...; // I'd use DI, but this could be manually created.
    public Browser create(String type) {
        return type.create();
    }
}