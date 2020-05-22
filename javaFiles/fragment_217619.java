listView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            Toast.makeText(getApplicationContext(), listView.getItemAtPosition(arg2).toString(), Toast.LENGTH_LONG).show();
    }
});