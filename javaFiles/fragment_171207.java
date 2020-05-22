class Proccess extends AsyncTask<String, Void, Void>{

@Override
protected Void doInBackground(String... arg0) {

    TextView txt = (TextView) findViewById(R.id.tvResult); // cuse error
    return null; //this should be the last statement otherwise cause unreachable code.
}

@Override
protected void onPreExecute() {
    super.onPreExecute();
    TextView txt = (TextView) findViewById(R.id.tvResult); // cuse error
}

@Override
protected void onPostExecute(Void result) {
    super.onPostExecute(result);
    TextView txt = (TextView) findViewById(R.id.tvResult); // cuse error

}
}