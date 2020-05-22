private class LoadImages extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            // Here you can do any UI operations like textview.setText("test");
        }

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub
Document doc = null;

    try {

        doc = (Document) Jsoup.connect("http://mongol.co.il/").get();
        Elements divs = ((Elements) doc).select("img[src$=.jpg]");

        for (org.jsoup.nodes.Element div : divs)
        {   
            list.add(div);
        }
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
        return null;
    }