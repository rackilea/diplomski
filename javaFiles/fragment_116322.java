public enum BrowserType {
    CHROME {
        public Browser create() {
            return new ChromeBrowser();
        }
    },
    IE {
        public Browser create() {
            return new IeBrowser();
        }
    }
    public abstract Browser create();
}

// Factory is optional really, the enum does the job.
public class BrowserFactor {

    public Browser create(BrowserType type) {
        return type.create();
    }
}