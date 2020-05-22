ValueCallback<Uri[]> mFilePathCallback;
@Override
 public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {

              if (mFilePathCallback != null) {
                    mFilePathCallback.onReceiveValue(null);
                }
                mFilePathCallback = filePathCallback;
                mFilePathCallback.onReceiveValue(myURI);
                mFilePathCallback = null;

                return true;

}