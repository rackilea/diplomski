private class GetLinks extends AsyncTask<Void, Void, List<Selfservice>> {

        @Override 
        protected void onPreExecute() { 
            super.onPreExecute(); 

        } 

        @Override 
        protected Void doInBackground(Void... arg0) {
                    Document doc;
                    Elements links;
                    List<Selfservice> returnList

                    try { 
                        doc = Jsoup.connect(url).timeout(10000).get();
                        links = doc.getElementsByClass("processlink");
                        returnList = ParseHTML(links);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } 

            return returnList; 
        } 

        @Override 
        protected void onPostExecute(List<Selfservice> result) {
            super.onPostExecute(result);
            runOnUiThread(new Runnable() {
                @Override 
                public void run() { 
                    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                    //setSupportActionBar(toolbar); 
                    //getSupportActionBar().setDisplayShowTitleEnabled(false); 
                    toolbar.setTitle("");
                    toolbar.setSubtitle("");

                    linkList = result
                    adapter = new CustomAdapter(con, result, res);
                    lv.setAdapter(adapter);
                } 
            }); 

        }