// assuming JS is enabled
private JavascriptExecutor js = (JavascriptExecutor)driver;
private WebElement lastElem = null;
private String lastBorder = null;

private static final String SCRIPT_GET_ELEMENT_BORDER;
private static final String SCRIPT_UNHIGHLIGHT_ELEMENT;

void highlightElement(WebElement elem) {
    unhighlightLast();

    // remember the new element
    lastElem = elem;
    lastBorder = (String)(js.executeScript(SCRIPT_GET_ELEMENT_BORDER, elem));
}

void unhighlightLast() {
    if (lastElem != null) {
        try {
            // if there already is a highlighted element, unhighlight it
            js.executeScript(SCRIPT_UNHIGHLIGHT_ELEMENT, lastElem, lastBorder);
        } catch (StaleElementReferenceException ignored) {
            // the page got reloaded, the element isn't there
        } finally {
            // element either restored or wasn't valid, nullify in both cases
            lastElem = null;
        }
    }
}