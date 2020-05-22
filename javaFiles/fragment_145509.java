private class Title extends AsyncTask<Void, Void, String> {

    ...

    @Override
    protected String doInBackground(Void... params) {
        String desc = null;
        try {
            // Connect to the web site
            Document document = Jsoup.connect(url).get();
            // Using Elements to get the Meta data
            Elements description = document.select("div[class=postContent]");
            // Locate the content attribute
            desc = description.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return desc;
    }

    @Override
    protected void onPostExecute(String result) {
        // Set description into TextView
        TextView txtdesc = (TextView) findViewById(R.id.desctxt);
        txtdesc.setText(result);
        mProgressDialog.dismiss();
    }

}