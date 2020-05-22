private class getTask extends AsyncTask<String, Integer, ArrayList<String[]>> {
    @Override
    protected ArrayList<String[]> doInBackground(String... args) {
        // Fetch your articles...
    }

    @Override
    protected void onPostExecute(ArrayList<String[]> newArticles) {
        // This runs on the UI thread
        articles = newArticles;

        // Refresh the list of articles...
        refreshArticles();
    }
}