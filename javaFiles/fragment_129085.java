public void addClickHandler(Callback callback) {
    _addClickHandler(getCallback(callback));
}

private native void _addClickHandler(JavaScriptObject callback) /*-{
     addEventListener('click', callback, false);
}-*/;

// This can be moved to a better place
private native static JavaScriptObject getCallback(Callback callback) /*-{
    return function()
    {
        callback.@path.to.your.package.Callback::execute()();
    };
}-*/;