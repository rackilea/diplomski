TextView currentSelection;
listView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
        currentSelection = (TextView)view;
    }
});