mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
        //load file to webView
        mWebView.loadUrl("REPLACE_IT_WITH_PATH_TO_FILE");
        //close drawer
        mDrawerLayout.closeDrawers();
    }
});