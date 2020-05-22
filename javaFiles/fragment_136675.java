@Override
 protected void onPostExecute(ArrayList<String> result) {
  super.onPostExecute(result);
   ArrayAdapter<String> adapter = new ArrayAdapter<String>(Board.this,R.layout.item, R.id.label, result);
   list1.setAdapter(adapter);
 }