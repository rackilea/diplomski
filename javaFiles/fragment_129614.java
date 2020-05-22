AsyncTask<Void, Void, List<Bitmap>>() {
        @Override
        protected  void onPreExecute()
        {
            //show progress dialog
            //Are you trying to prevent the user from clicking on the UI while updating?
            //You can do something such as:
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

        @Override
        protected List<Bitmap> doInBackground(Void... voids) {
            //perform the logic, this will return a list of all the Bitmaps to onPostExecute
            //Do NOT perform any ui logic here.
        }

        @Override
        protected void onPostExecute(List<Bitmap> bitmaps) {
            //cancel progress dialog.
            //Update the UI with the response.
            //Clear the window lock:
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    };