public class ElementPresenceWait extends Wait {
    private final String locator;

    public ElementPresenceWait(final String locator) {
        this.locator=locator;
    }

    @Override public boolean until(){
        selenium.isElementPresent(locator);
    }

    public void wait(long timeoutInMilliseconds) {
        wait("Cannot found locator " + locator, timeoutInMilliseconds);
    }
}