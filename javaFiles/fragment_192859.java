@Override
protected void onPostExecute(String message) {
    super.onPostExecute(message);

    Adapter adptor=new Adapter(MainActivity.this,details);
    ListView l= (ListView) findViewById(R.id.listview);
    l.setAdapter(adptor);
}