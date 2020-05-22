public void handleEvent(Event event) {
    if (event.widget instanceof Control) {
        Point absolutePos = ((Control) event.widget).toDisplay(event.x, event.y);
        ...
    }
}