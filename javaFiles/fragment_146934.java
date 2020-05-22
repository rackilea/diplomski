@Override
public void renderHead(final IHeaderResponse response) {
    super.renderHead(response);

    // Ensure that Wicket's jQuery library is always loaded, so we can invoke our own jQuery calls
    response.render(JavaScriptReferenceHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings().getJQueryReference()));
    response.render(JavaScriptReferenceHeaderItem.forReference(CoreUIJavaScriptResourceReference.get()));
}