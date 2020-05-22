class myClass extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            String result = uploadPhotos();
            proccess result;
            send links;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent randomintent = new Intent(profile.this, loggedactivity.class);
            randomintent .putString("name", namestring);
            startActivity(randomintent);
        }
    }