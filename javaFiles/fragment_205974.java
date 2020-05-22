countDownTimer = new CountDownTimer(10000, 5000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }
        @Override
        public void onFinish() {
            new requestAsyncTask().execute();
        }
};
countDownTimer.start();


class requestAsyncTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        countDownTimer.cancel();
        countDownTimer.start();
    }

    @Override
    protected Void doInBackground(Void... params) {
        API_StreamImage_Request();
        return null;
    }
}