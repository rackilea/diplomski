OnItemClickListener listViewOnItemClick = new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> adapter, View arg1, int position, long id) {
        mSelectedItem = position;
        mAdapter.notifyDataSetChanged();
    }
};