final ArrayAdapter<Item> adapter =
            new ArrayAdapter<Item>(this,R.layout.list_item, items);
listView.setAdapter(adapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long title) {

        items.get(position).setExpand(true);
        adapter.notifyDataSetChanged();

    }
});