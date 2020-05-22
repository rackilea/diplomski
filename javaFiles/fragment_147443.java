private ArrayList<String> mData = new ArrayList<String>();
private ArrayAdapter<String> mAdapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // ...
    // Code that adds the strings
    // Create the list adapter
    mAdapter = new ArrayAdapter<String>(myActivity.this, android.R.layout.simple_list_item_1, mData);
}

private void removeItem(int index) {
    mData.removeAt(index);
    myActivity.this.runOnUiThread(new Runnable() {
        public void run() {
            mAdapter.notifyDataSetChanged();
        }
    }
}