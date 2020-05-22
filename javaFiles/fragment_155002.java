private void addDrawerItems() {
    String[] osArray = { "Android", "black" };
    //create also an array of paths to html files
    final String[] pathsArray = { "file:///android_asset/www/help.html", "HERE_MUST_BE_ANOTHER_PATH_TO_ANOTHER_FILE" };
    mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
    mDrawerList.setAdapter(mAdapter);

    mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
            //load file to webView from pathsArray
            // getting current path from arg. position
            mWebView.loadUrl(pathsArray[position]);
            //close drawer
            mDrawerLayout.closeDrawers();

        }
    });
}