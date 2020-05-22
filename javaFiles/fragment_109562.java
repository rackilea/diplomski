package com.test.gwt;

import com.google.gwt.event.shared.EventHandler;

public interface DOMNodeInsertedEventHandler extends EventHandler {
    void onDOMNodeInserted(DOMNodeInsertedEvent event);
}