private class Task extends AsyncTask<Void , Void , Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try
            {
                URL url = new URL("http://google.com");
                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setReadTimeout (10 * 1000);

                int rc = uc.getResponseCode();
                Log.d("rc" , rc+"");
            }
            catch (Exception e)
            {

            }
            return null;
        }
    }

 new Task().execute();