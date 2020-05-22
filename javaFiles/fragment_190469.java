private native JavaScriptObject _init(TableElement element) /*-{
    var c = $wnd.jQuery(element);
    var dataTable = c.dataTable({
        "bAutoWidth" : false
    });
    return dataTable;
}-*/;