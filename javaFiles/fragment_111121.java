// ** This call results in a runtime error for null pointer reference.
passagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position,long arg3) {
        Toast.makeText(getContext(), "Foo", Toast.LENGTH_SHORT).show();
    }
});