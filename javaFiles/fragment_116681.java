@Override
protected void onPostExecute(Void aVoid) {
    //Dismiss progress dialog
    super.onPostExecute(aVoid);
    progressDialog.dismiss();

    // ADD LINES BELOW
    if(listView != null) {
        MyAdapter  adapter = new MyAdapter(context,android.R.layout.simple_list_item_1,feedItems);
        listView.setAdapter(adapter);
    }       
}