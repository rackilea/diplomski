private void GetUserImage() {

            imguser=(ImageView)findViewById(R.id.imguser);
            new AsyncTask<Void, Void, Bitmap>() {

                @Override
                protected Bitmap doInBackground(Void... params) {
                    Bitmap bitmap = null;
                    try {
                        String imageUrl = "http://10.0.2.2:8080/Clibrary/biss.jpg";
                      bitmap=  BitmapFactory.decodeStream((InputStream) new URL(imageUrl).getContent());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } 
                    return bitmap;
                }

                @Override
                protected void onPostExecute(Bitmap bitmap) {
                    super.onPostExecute(bitmap);
                    imguser.setImageBitmap(bitmap);
                }
            }.execute();

        }