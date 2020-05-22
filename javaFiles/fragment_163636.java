public void onCreateContextMenu(ContextMenu Menu, View v, ContextMenu.ContextMenuInfo MenuInfo){
    super.onCreateContextMenu(Menu, v, MenuInfo);
    final WebView.HitTestResult result1 = webview1.getHitTestResult();
    final WebView.HitTestResult result2 = webview2.getHitTestResult();
    if(v.getId() == R.id.webview2){
        if (result1.getType() == WebView.HitTestResult.ANCHOR_TYPE ||
                result1.getType() == WebView.HitTestResult.SRC_ANCHOR_TYPE) {
            Menu.add(0, 1, 0, "Open Link").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem)
                {
                    webview1.loadUrl(result1.getExtra());
                    return false;
                }
            });
        }
    }
    else if(v.getId() == R.id.webview1)
    {
        if (result2.getType() == WebView.HitTestResult.ANCHOR_TYPE ||
                result2.getType() == WebView.HitTestResult.SRC_ANCHOR_TYPE) {
            Menu.add(0, 1, 0, "Open Link").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem)
                {
                    webview2.loadUrl(result2.getExtra());
                    return false;
                }
            });
        }

    }
}