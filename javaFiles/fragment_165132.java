private View getView() {
    try {
        return (View)webView.getClass().getMethod("getView").invoke(webView);
    } catch (Exception e) {
        return (View)webView;
    }
}