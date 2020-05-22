DOMElement element = browser.getDocument().findElement(By.id("startTimeField"));
element.addEventListener(DOMEventType.OnChange, new DOMEventListener() {
    public void handleEvent(DOMEvent event) {
        // your code for reacting to the change here
    }
}, false);