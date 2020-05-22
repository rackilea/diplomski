private class NetworkRequest extends AsyncTask<String, Void, String> {
    int userid;
    double lat, lon;
    String reponse;

    public NetworkRequest(int userID, double lat, double lon) {
        this.userid = userID;
        this.lon = lon;
        this.lat = lot;
    }

    @Override
    protected String doInBackground(String... params) {
        reponse = findUsersInCurrentRadius(userid, lat, lon);
        return "Executed";
    }

    @Override
    protected void onPostExecute(String result) {
        if (null != reponse) {
            System.out.println("Got Data" + reponse);
            textView.setText(reponse);
        }
        else{
            //Handle the Error
        }
    }

}