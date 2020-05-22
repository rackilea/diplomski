@Override
        protected Void doInBackground(Void... params) {             
            try {
                URL myFileUrl = new URL("http://sposter.smartag.my/images/chicken_soup.jpg");
                HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                downloadBitmap = BitmapFactory.decodeStream(is);
                            } catch (FileNotFoundException e) {             
                e.printStackTrace();
            }
            catch (IOException e) {         
                e.printStackTrace();
            }               
            return null;
        }

@Override
onPostExecute()
{
 ImageView image = (ImageView) findViewById(R.id.imview);            
            image.setImageBitmap(downloadBitmap);
}