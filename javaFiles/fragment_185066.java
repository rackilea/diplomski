@Override
protected Object[] doInBackground(Object[] Objects) {
    TextView affected_route = (TextView)findViewById(R.id.disrupted_route);
    //affected_route.setText(Objects[0].toString()); crash, instead do this in onPostExecute

    return null;
};