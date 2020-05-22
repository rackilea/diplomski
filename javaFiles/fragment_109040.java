public void scoreOpenB(View v) {

        View updateMe = findViewById(R.id.main_mess);
        updateMe.setVisibility(View.GONE);

        new UpdateUI().execute(updateMe);
    }
}


private class updateUI extends AsyncTask<View, Integer, Long> {
    View toUpdate;

    protected void doInBackground(View view) {
        toUpdate = view;
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    protected void onProgressUpdate(Integer... progress) {
    }

    protected void onPostExecute(Long result) {
        (toUpdate(TextView)).setText(R.string.btn_closs);
        toUpdate.setVisibility(View.VISIBLE);

    }
}