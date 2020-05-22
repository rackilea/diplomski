@Override
public void onClick(View arg0) {
    new LoginTask.execute();
});


class LoginTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected void onPostExecute(Bitmap result) {
        if (everythingGood) {
            showToast("Success!");
            startActivity(new Intent());
        } else {
            showAlert("Error!");
        }
    }        

    @Override
    protected Void doInBackground(Void... params) {
        loginToTwitter();
    }
}