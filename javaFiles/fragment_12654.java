listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long arg3) {
        // get the data from your list at position, i.e. data.get(position)
        // then pass that object / id to your database helper, e.g.

        Person p = data.get(position);
        personDatabaseHelper.deleteItem(p.getId());

        data.remove(position); // or adapter.remove(p), depends on your implementation
        adapter.notifyDataSetChanged(); // remove the object from your Adapter and notify it of the change

        return true;
    }
});