public class DownloadImage extends AsyncTask<Void, Void,  ArrayList<Drawable>> {



        /**
         * Called after the image has been downloaded
         * -> this calls a function on the main thread again
         */
        protected void onPostExecute( ArrayList<Drawable> drawable)
        {
            setImage(drawable);
        }
        protected void onPreExecute()
        {
            Log.i("333333", "Uruchamiam WATEK SCIAGANIA ASYNCTASKIEM PLIKU Z NETA");
        }

        @Override
        protected  ArrayList<Drawable> doInBackground(Void... params) {

            downloadImage();
            return drawable;
        }




 private void setImage(ArrayList<Drawable> drawable)
    {
        if(drawable.get(0) == null)
        {
            System.out.println("DRAWABLE JEST NULL");
        }
        mImageView.setBackgroundDrawable(drawable.get(0));
        mImageView2.setBackgroundDrawable(drawable.get(1));
    }