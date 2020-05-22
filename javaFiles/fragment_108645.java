private class TastingUniRestAsync extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... urls) {
        String pathToFile = urls[0];
        String responseResult = "";
        HttpResponse<JsonNode> response = Unirest.get(pathToFile)
                .header("X-Mashape-Key", "**********apikey************")
                .header("Accept", "application/json")
                .asJson();

        if(null != response){
            //convert your response to the data type you want. Here I am using string
            responseResult = //assign the manipulated Json string;
        }
        return responseResult
    }
    protected void onPostExecute(String responseResult){
        // You can assign it to TextView widget for example
        mTextView.setText(responseResult);
    }
}