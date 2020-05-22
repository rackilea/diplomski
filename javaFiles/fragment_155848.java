StringBuilder sb = new StringBuilder();
sb.append("<HEAD>");
sb.append("<meta name=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1.0, user-scalable=no\" />");
    sb.append("</HEAD>");

// add these to webview settings
webview.getSettings().setUseWideViewPort(true);
webview.getSettings().setLoadWithOverviewMode(true);

webview.loadDataWithBaseURL("http://www.example.com", sb.toString(), "text/html", "UTF-8", "");