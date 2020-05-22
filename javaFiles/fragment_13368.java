@Override
 protected Void doInBackground(Void... arg0) {

       DefaultHttpClient client = null;

       HttpGet getMethod = null;

       HttpResponse response = null;

       HttpEntity entity = null;

       URI requestUri = null;


       try {

           client       = new DefaultHttpClient();

           requestUri   = new URI("http://gdata.youtube.com/feeds/api/videos/"
                                 + video_id
                                 + "/comments?v=2&alt=json&start-index=1&max-results=50&prettyprint=true");

           getMethod    = new HttpGet(requestUri);

           response     = client.execute(getMethod);

           if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){

               entity = response.getEntity();

               String jsonString = EntityUtils.toString(entity);

               JSONObject json   = new JSONObject(jsonString);

               // Get the Feed From the JSON Response
               JSONObject feeds         = json.getJSONObject("feed");
               JSONArray entryArray     = feeds.getJSONArray("entry");

               for(int i = 0; i < entryArray.length(); i++){

                   // Get the entry at index 0
                   JSONObject entry = entryArray.getJSONObject(i);

                   // Get the Published data
                   JSONObject publishedObject = entry.getJSONObject("published");
                   published = publishedObject.getString("$t");


                   // Get the Content of the Comment
                   JSONObject contentObject = entry.getJSONObject("content");
                   content = contentObject.getString($t);

                   // Get the Author of the content
                   JSONArray commentNames = entry.getJSONArray("author");
                   for(int j = 0; j < commentNames.length(); j++){

                       // Get the Author Object at the first index
                       JSONObject singleAuthor = commentNames.getJSONObject(j);
                       JSONObject authorName = singleAuthor.getJSONObject("name");

                       name = authorName.getString("$t");
                   }

                   comments.add(new CommentsLibrary(name, content, published));

               }

           }
        }catch (ClientProtocolException e) {
                Log.d("ClientProtocolException", ""+ e);

        }catch(URISyntaxException e){

             Log.d("URISyntaxException",""+ e);
        } catch (IOException e) {
                Log.d("IOException",""+ e);
        } catch (JSONException e) {
                Log.d("JSONException",""+ e);
        }
            return null;
    }