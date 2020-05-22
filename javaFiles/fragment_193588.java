private class DownloadWebPageTask extends AsyncTask<Void, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(Void... urls) {
           load();
            if(pictures == null) {
               return null;
            } else{
                Picture picture = pictures.get(position);
                if (picture == null)
                    return null;
                else
                    return picture.getImage();
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap == null){
                //Show error
            } else{
                ImageView image = (ImageView) findViewById(R.id.image);
                image.setImageBitmap(bitmap);
            }
        }
    }