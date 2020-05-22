public abstract class AbstractPage {

    protected WebConversation webConversation;

    protected Logger logger;

    protected AbstractPage(AbstractPage other) {
        this.webConversation = other.getWebConversation();
        this.logger = Logger.getLogger(this.getClass());
    }

    protected AbstractPage(WebConversation webConversation) {
        this.webConversation = webConversation;
        this.logger = Logger.getLogger(this.getClass());
    }

    public WebConversation getWebConversation() {
        return webConversation;
    }

    public void doLogout() throws SAXException, IOException {    
        WebLink logoutLink = webConversation.getCurrentPage().getLinkWithID("logoutLink");
        assertNotNull(logoutLink);
            logoutLink.click();
    }
}