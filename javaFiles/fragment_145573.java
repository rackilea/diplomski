private class GetData extends AsyncTask<Void, Void, HashMap<String, String>>() {
    @Override
    protected HashMap<String, String> doInBackground(Void... voids) {
        HashMap<String, String> accDetails = new HashMap<String, String>();
            //Your GSON decoding
        return accDetails ;
    }

    @Override
    protected void onPostExecute(HashMap<String, String> accDetails ) {
       // Display the text in your TextView i.e.
       // yourTextView.setText = accDetails.get("billToAddress");
    }
};