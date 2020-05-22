@Override
protected void onPostExecute(ArrayList<String> stringsArray) {
    //add the tours from internet to the array
    if(stringsArray != null) {
        mStrings.addAll(toursArray);
        // call notifyDataSetChanged() here...
         MyListAdapter.this.notifyDataSetChanged();
    }
}