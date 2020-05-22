public native void addDOMNodeInsertedEventHandler(Widget widget, Element element)/*-{
    $wnd.$(element).bind('DOMNodeInserted', function (event) {
        var gwtEvent = @com.test.gwt.DOMNodeInsertedEvent::new()();
        widget.@com.google.gwt.user.client.ui.Widget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(gwtEvent);
    });
}-*/;