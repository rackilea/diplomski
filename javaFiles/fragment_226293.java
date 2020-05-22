new AsyncTask<String, String, String> () {

    @Override
    protected void onPreExecute() {
        //show loader if requried
    }

    @Override
    protected String doInBackground(String... params) {

        Long TotalJunk = 0L;
        for (Apps social : checkedSocial) {
            if (social.getName() == "Telegram") {
                preresult.setText("Calculating Files :");
                resulttxt.setText("Telegram");
                preresult.setText("Removing Files...");
                clearMediashistory(social.path);
                TotalJunk = TotalJunk + social.junksize;
            }
        }
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("FreeUp", formatSize(TotalJunk));
        //commits your edits
        editor.commit();
    }

    @Override
    protected void onPostExecute(String result){

        ProgressBar spinner;
        spinner = (ProgressBar) findViewById(R.id.progressBar);
        listview.setVisibility(View.GONE);
        spinner.setVisibility(View.VISIBLE);
        preresult.setVisibility(View.VISIBLE);
        resulttxt.setVisibility(View.VISIBLE);
        wv.setVisibility(View.VISIBLE);
        btnClear.setVisibility(View.GONE);
        wv.loadUrl("file:///android_asset/rocket.gif");
        resulttxt.setText("");
    }

}.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTER);