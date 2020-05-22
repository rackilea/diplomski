private class SendHttpRequestTask extends AsyncTask<String, Void, Bitmap> {
            @Override
            protected Bitmap doInBackground(String... params) {
                try {
                    URL url = new URL("http://xxx.xxx.xxx/image.jpg");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    Bitmap myBitmap = BitmapFactory.decodeStream(input);
                    return myBitmap;
                }catch (Exception e){
                    Log.d(TAG,e.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                    ImageView imageView = (ImageView) findViewById(ID OF YOUR IMAGE VIEW);
                    imageView.setImageBitmap(result);
            }
    }