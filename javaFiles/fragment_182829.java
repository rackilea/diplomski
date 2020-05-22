@Override
    public void onPageFinished(WebView view, String url) {

        if (url.startsWith("http://crm.example.com/user.php") {
            wb.loadUrl("http://crm.example.com/customer.php?action=trafik");
        }

    }