class loadFeedTask extends AsyncTask<String, Void, ArrayList<MangaItem>> {
    protected void onPostExecute(ArrayList<MangaItem> list) {
        lv1.setAdapter(new EfficientAdapter(MainActivity.this, list));
        ShowProgress.dismiss();
    }
    protected ArrayList<MangaItem> doInBackground(String... params) {
        ArrayList<MangaItem> list=null;
        String feedUrl = "http://www.mangapanda.com/alphabetical"; 
        FeedParser parser = new SaxFeedParser(feedUrl);
        list = parser.parse();
        MangaItemList=list;
        return list;
    }
  }