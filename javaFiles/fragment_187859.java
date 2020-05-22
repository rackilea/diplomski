try
            {
                HttpClient client=new DefaultHttpClient();
                HttpGet request=new HttpGet("http://muslimsalat.com/daily.json?key=5ad273b81ff66c6f3248604cfc728baa");
                HttpResponse response=client.execute(request);

                HttpEntity entity=response.getEntity();
                String json=EntityUtils.toString(entity);

                JSONObject jsonObject=new JSONObject(json);

                Toast.makeText(MainActivity.this, jsonObject.getString("title")+"\n"+jsonObject.getString("prayer_method_name"), 0).show();

                entity.consumeContent();
            }
            catch(Exception e)
            {
                e.getStackTrace();
                Toast.makeText(MainActivity.this, e.toString()  , 0).show();
            }