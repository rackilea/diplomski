mMyLst = (ListView) findViewById(lstMy);
mMyLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        MyListData data = (MyListData) parent.getItemAtPosition(position);
        selectedName = data.getName();

        Intent intent = new Intent(ShowListDataActivity.this, MainActivity.class);
        startActivity(intent);
    }
});

mMyLst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        MyListData data = (MyistData) adapterView.getItemAtPosition(i);
        selectedName = data.getFirstName();

        selectedTicketPosition = i;
        // removeValue is my own method for removing an entry from the 
        // list MyListData and then call adapter.notifyDataSetChanged();
        removeValue(i);

        return true;
    }
});