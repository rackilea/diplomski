private static final long WAIT_TIME = 30000;

public WebElement findElement(final By by) {
    WebElement elem = null;
    long targetTime = System.currentTimeMillis() + WAIT_TIME;
    do {
        try {
            elem = driver.findElement(by);
        } catch (NoSuchElementException ignored) {
            // nothing to do, element not found
        }
    } while ((elem == null) && (System.currentTimeMillis() < targetTime));
    if (elem == null) {
        throw new NoSuchElementException("No such element found: " + by);
    }
    System.out.println("Waited for " + (targetTime - System.currentTimeMillis()) + " ms.");
    return elem;
}