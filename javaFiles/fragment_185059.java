TextView maintext = (TextView) findViewById(R.id.maintext);
 Thread downloadThread = new Thread() {
        public void run() {
            Document doc;
            try {
                doc = Jsoup.connect("http://www.stackoverflow.com").get();
                titlestring = doc.title();

             runOnUiThread(new Runnable()
                     {
                       run(){
                    Log.i("wbbug", "Title string: " + titlestring);
                    maintext.setText(titlestring);
                            }
                     }

                } catch (IOException e) {
                e.printStackTrace();
                }
        }
    };
    downloadThread.start();