private class getAtcUserAsyncTask extends AsyncTask<Void, Void, Void> {
   String name;


    getAtcUserAsyncTask(String name) {
        this.name = name;
    }

    @Override
    protected Void doInBackground(Void... params) {
        setAtcUserStats(mAtcDao.findByName(name));
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ATC_GameOver atc_gameOver = new ATC_GameOver();
        atc_gameOver.callOnChanged(atcUserStats);
    }
}

private void setAtcUserStats(AtcUserStats byName) {
    atcUserStats = byName;
}