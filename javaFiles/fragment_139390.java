public class WelcomePage extends AbstractPage  {

    protected WelcomePage(AbstractPage other) {
        super(other);

        String expected = String.format("/%s/welcome.do", Config.endpoint);
        assertEquals(expected, webConversation.getCurrentPage().getURL().getPath());
        logger.info(String.format("Current page: %s", webConversation.getCurrentPage().getURL().getPath() ));
    }

    public FilterPage goToFilterPage() throws SAXException, IOException {
        WebLink link = webConversation.getCurrentPage().getLinkWithID("downloadLink");
        assertNotNull("Check if link exist on page", link);
        link.click();    
        return new FilterPage(this);
    }    
}