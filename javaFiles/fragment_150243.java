@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    final WebView.HitTestResult result = browser.getHitTestResult();
    MenuItem.OnMenuItemClickListener handler = new MenuItem.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem item) {
            // handle on context menu click
            return true;
        }
    };

    if (result.getType() == WebView.HitTestResult.IMAGE_TYPE ||
            result.getType() == WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE) {

        menu.setHeaderTitle(result.getExtra());
        menu.add(0, 666, 0, "Save Image").setOnMenuItemClickListener(handler);
    }
}