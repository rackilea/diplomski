public class MultiplyTask extends AsyncTask<Void, Bitmap, Bitmap[]> {

    public MultiplyResponseReceiver listener;

    @Override
    protected void onPreExecute() {
        //super.onPreExecute();

    }

    @Override
    protected Bitmap[] doInBackground(Void... progress_data) {

        Bitmap[] bitmapArray = new Bitmap[2];
        bitmapArray[0] = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_base);
        bitmapArray[1] = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_hat);
        //publishProgress(bitmapArray);
        return bitmapArray;
    }

    @Override
    protected void onProgressUpdate(Bitmap... bitmapArray) {
        //super.onProgressUpdate(values);\


    }

    @Override
    protected void onPostExecute(Bitmap[] bitmapArray) {
        // super.onPostExecute(s);
        listener.onMultiplyResponseReceived(bitmapArray);
    }
}