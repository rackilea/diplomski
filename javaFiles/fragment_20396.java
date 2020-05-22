class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap>
{
    @Override
    protected Bitmap doInBackground(String... params) {

        Bitmap bitmap = null;

        for (int tryouts=0; tryouts<3; tryouts++) {
            try
            {
                InputStream is = fetch(params[0]);
                bitmap = BitmapFactory.decodeStream(is);
                is.close();
                is = null;

                break;
            }
            catch(IOException exception)
            {
                bitmap = null;
            }
            catch (OutOfMemoryError e) 
            {
                System.gc();
                bitmap = null;
            }
        }

        return bitmap;
    }
}