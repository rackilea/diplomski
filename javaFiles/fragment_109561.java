package com.test.gwt;

import com.google.gwt.event.shared.GwtEvent;

public class DOMNodeInsertedEvent extends GwtEvent<DOMNodeInsertedEventHandler> {
    public static Type<DOMNodeInsertedEventHandler> TYPE = new Type<DOMNodeInsertedEventHandler>();

    public Type<DOMNodeInsertedEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(DOMNodeInsertedEventHandler handler) {
        handler.onDOMNodeInserted(this);
    }
}