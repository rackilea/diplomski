ListView listView = (ListView) findViewById(R.id.my_listview_in_layout);
listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        //Do stuff
        //...
    }
});