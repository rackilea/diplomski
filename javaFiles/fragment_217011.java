class LoadData extends AsyncTask<String, String, String>
{

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        dxml = new DownloadXML();
        in_loc = inloc.getText().toString();
        dxml.checkInetConnection(this,in_loc);
        return null;
    }
    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
             outloc.setText(hxml.getLocation());
             outtemp.setText(hxml.getTemperature());
        super.onPostExecute(result);
    }
}