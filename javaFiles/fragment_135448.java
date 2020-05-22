@Override
public void onClick(View v) {
    if(v.getId() == R.id.btnNext){

                try {

                    books.removeAllViews();
                    int i = pagecount + y;
                    y = i;
                    webView = new WebView(this);
                    books = (LinearLayout) findViewById(R.id.book);
                    data = new String(book.getContents().get(y).getData());
                    webView.loadDataWithBaseURL("file:///android_asset/", data, "text/html", "UTF-8", null);
                    books.addView(webView);
                } catch (IOException e) {
                    e.printStackTrace();
                }

    }else if(v.getId() == R.id.btnPreviuse){
                try {
                    books.removeAllViews();
                    int i = y - pagecount;
                    y = i;
                    webView = new WebView(this);
                    books = (LinearLayout) findViewById(R.id.book);
                    data = new String(book.getContents().get(y).getData());
                    webView.loadDataWithBaseURL("file:///android_asset/", data, "text/html", "UTF-8", null);
                    books.addView(webView);
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

}