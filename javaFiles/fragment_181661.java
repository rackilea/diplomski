listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Item passItem = itemList.get(position);
            Intent intent = new Intent(ItemListView.this, ViewItemClicked.class);
            Bundle itemBundle = new Bundle();
            itemBundle.putSerializable("dataItem",passItem)// put the data and define the key
            intent.putExtras(itemBundle)
            startActivity(intent);
        }
    });