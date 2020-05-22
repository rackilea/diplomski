myWebView.setWebChromeClient(new WebChromeClient() {
    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, 
        GeolocationPermissions.Callback callback) {
        callback.invoke(origin, true, false);
    }
});