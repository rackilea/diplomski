table.addEventFilter(ScrollEvent.ANY, Event::consume);

// or if you only want to disable horizontal scrolling
table.addEventfilter(ScrollEvent.ANY, event -> {
    if (event.getDeltaX() != 0) {
        event.consume();
    }
});