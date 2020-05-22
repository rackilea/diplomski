private void uploadToServer(byte[] data) {
    Bitmap bitmapOrg = BitmapFactory.decodeByteArray(data, 0, data.length);
    ByteArrayOutputStream bao = new ByteArrayOutputStream();
    bitmapOrg.compress(Bitmap.CompressFormat.JPEG, 90, bao);
    byte[] ba = bao.toByteArray();
    String ba1 = Base64.encodeBytes(ba);
    final ArrayList<NameValuePair> nameValuePairs = new
    ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("image", ba1));
    Thread t = new Thread() {
        @Override
        public void run() {
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new
                HttpPost("http://www.yoururl.com");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                // HttpEntity entity = response.getEntity();

                // is = entity.getContent();
                // String the_string_response =
                // convertResponseToString(response);
                // Log.e("log_tag", "Image Uploaded  "+the_string_response);
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
        }
    };

}