@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode== Activity.RESULT_OK && requestCode==123){
        // perform your list addition operation here and notify the adapter for change
        // the returned data comes in 'data' parameter and would recommend you to use parcels.org lib
        // for sending parcelable pojo across activities and fragments. 
        list.add(Parcels.unwrap(data.getParcelableArrayExtra(YOUR_KEY)));
        adapter.notifyDataSetChanged();
    }
}