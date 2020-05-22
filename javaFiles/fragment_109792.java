private class DownloadFilesTask extends AsyncTask<Void, Void, Void> {
             Drawable drawable;

             @Override
             protected Void doInBackground(Void... params) {
             drawable = createDrawableFromURL(
                                   "http://savagelook.com/misc/sl_drop2.png");
              return null;
             }
             protected void onPostExecute(Void result) {
                    imageView.setImageDrawable(drawable);
            }          
        }