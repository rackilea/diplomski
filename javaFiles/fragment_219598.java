@Override
protected void onPostExecute(JSONObject json) {

    try {
        // Getting JSON Array from URL
        rating = json.getJSONArray(TAG_ITEM);

        for(int i = 0; i < rating.length(); i++)
        {
            JSONObject c = rating.getJSONObject(i);
            // Storing  JSON item in a Variable
            String name = c.getString(TAG_NOME);
            String commento = c.getString(TAG_COMMENTO);
            String valore = c.getString(TAG_VALORE);
            String imageUrl = c.getString(TAG_URLIMAGE);
            String timestamp = c.getString(TAG_TIMESTAMP);
            Log.i("Url immagine", imageUrl);// here it shows 2 url and it's ok

            // Adding value HashMap key => value
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(TAG_NOME, name);
            map.put(TAG_COMMENTO, commento);
            map.put(TAG_IMAGEURL, imageUrl);
            map.put(TAG_VALORE, "Voted: "+valore);
            map.put(TAG_TIMESTAMP, timestamp);
            oslist.add(map);

            ListAdapter adapter = new SimpleAdapter(RatingDetailsActivty.this, oslist, R.layout.list_rating_item,
                    new String[]
                            { TAG_NOME,
                                    TAG_COMMENTO,
                                    TAG_VALORE,
                                    TAG_IMAGEURL,
                                    TAG_TIMESTAMP
                            }, new int[]
                    {
                            R.id.nome,
                            R.id.commento,
                            R.id.valore,
                            R.id.timestamp
                    });
        }
        list.setAdapter(adapter);
    } catch (JSONException e) {
        e.printStackTrace();
    }
}