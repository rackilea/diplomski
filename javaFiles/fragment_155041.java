private native void selectAll(Element element) /*-{
    element.setSelectionRange(0, element.value.length);
}-*/;

final Element desc = Document.get().createTextInputElement();
DOM.sinkEvents((com.google.gwt.user.client.Element) desc, Event.ONCLICK);
DOM.setEventListener((com.google.gwt.user.client.Element) desc, new EventListener() {
    @Override
    public void onBrowserEvent(Event e) {
        switch (DOM.eventGetType(e)) {
            case Event.ONCLICK:
                selectAll(desc);
                break;
        }
    }
});