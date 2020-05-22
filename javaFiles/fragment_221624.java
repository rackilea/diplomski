listView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "clicked on item: " + position);
        Intent intent = new Intent(List.this, Edit.class);

        //change this to your actual code
        String name = listView.getAdapter().getItem(position).getName();
        intent.putExtra("id", position);  
        intent.putExtra("name", name);
        //put the rest of the data here
        startActivity(intent);
    }
});