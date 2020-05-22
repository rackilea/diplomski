class ParserTask extends AsyncTask<String, List<Message>, Long> {

    protected Long doInBackground(String... urls) {
        if (urls == null || urls.length == 0)
            return null;
        for (String url : urls) {
            SaxFeedParser rss = new SaxFeedParser(url);
            List<Message> messages = rss.parse();
            publishProgress(messages);
        }
        return null; //return somethingForPostExecute;
    }

    protected void onProgressUpdate(List<Message>... messages) {
        if (messages == null || messages.length == 0)
            return;
        for (Message message : messages[0]) {
            // tv.appendText(message);
            // or call method from GUI thread (the activity)
        }
    }

    protected void onPostExecute(Long nr) {

    }
}