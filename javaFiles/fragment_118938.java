ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmapOrg.compress(Bitmap.CompressFormat.JPEG, 90, bao);
        byte [] ba = bao.toByteArray();
        String ba1= Base64.encodeToString(ba, 0);
         ArrayList<NameValuePair> nameValuePairs = new
ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("image",ba1));

try{

                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://your_url/sink.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
          }catch(Exception e){

                Log.e("log_tag", "Error in http connection "+e.toString());
          }