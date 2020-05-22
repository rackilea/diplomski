listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            itemList_Results obj = (itemList_Results)listView.getItemAtPosition(position);
            Toast.makeText(genres_listView.this,obj.getTitle(),Toast.LENGTH_LONG).show();
        }
    });