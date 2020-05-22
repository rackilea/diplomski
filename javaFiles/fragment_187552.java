@Override
public void renderHead(IHeaderResponse response) {
    super.renderHead(response);

    response.render(CssHeaderItem.forUrl("http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"));
    response.render(CssHeaderItem.forUrl("http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"));

    // First render the JQuery reference
    response.render(JavaScriptHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings().getJQueryReference()));

    // Then render the dependent JavaScript libraries
    response.render(JavaScriptHeaderItem.forUrl("http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"));
    response.render(JavaScriptHeaderItem.forUrl("http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"));

    // Finally render the dom ready script
    response.render(OnDomReadyHeaderItem.forScript("$('#myTable').dataTable();"));
}