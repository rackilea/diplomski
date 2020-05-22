//on-click listeners for buttons; retrieve XML info
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadFilesTask(listview_item_or_adapter_reference).execute(roadsURL);
            }
        });


 private class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {

     private static final String TAG = HandleXML.class.getSimpleName();                 
     //Logcat tag for debugging
     private String urlString = null;
     private XmlPullParserFactory xmlFactoryObject;
     private ListView item;

     public DownloadFilesTask(ListView item){
     this.item = item;
     }

     protected String doInBackground(URL... urls) {
 try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) 
                    url.openConnection();
                    //HttpURLConnection settings
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setAllowUserInteraction(false);
                    conn.setInstanceFollowRedirects(true);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);

                    // Starts the query
                    conn.connect();
                    InputStream stream = conn.getInputStream();

                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser = xmlFactoryObject.newPullParser();

                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(stream, null); //set XML source as stream


                    stream.close();
                }

                catch (Exception e) {
                    e.printStackTrace();
                }
         return totalSize;
     }

     protected void onPostExecute(String result) {
         showDialog("Downloaded  data,pasring now...");
         parseXMLAndStoreIt(myparser);
         //update item or adapter here
     }






       private void printItems(ArrayList<Item> items)
    {
        ListView lv = (ListView)findViewById(R.id.info); //scroll area listview

        //adapter with pre-defined layout for listview, source arraylist
        ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_2 , items);
        lv.setAdapter(adapter); //link adapter to listview
    }

      public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        ArrayList<Item> items = new ArrayList(); //arraylist for item objects
        String text = null;
        Item currentItem = null;

        try {
            event = myParser.getEventType(); //return event type from XML

            while (event != XmlPullParser.END_DOCUMENT) {
                String name = null;

                switch (event){
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG: //parse by item tag, then by sub-tags
                        name = myParser.getName();
                        if (name.equals("item")){
                            currentItem = new Item(); //new item object for arraylist
                        } else if (currentItem != null){
                            if (name.equals("title")){
                                currentItem.title = text;
                            } else if (name.equals("description")){
                                currentItem.description = text;
                            } 
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText(); //retrieve text value from tag
                        break;

                    case XmlPullParser.END_TAG:

                        name = myParser.getName();
                        if (name.equalsIgnoreCase("item") && currentItem != null) {
                            items.add(currentItem); //add to arraylist
                            //Log.e(TAG, "parse: added new item "); //DEBUG - print the code to logcat
                        }
                }

                event = myParser.next();
            }
            printItems(items); //get arraylist info to screen
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

 }