ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createHelperCallback());
itemTouchHelper.attachToRecyclerView(recyclerView);
private ItemTouchHelper.Callback createHelperCallback() {
    ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
            new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                    ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                      RecyclerView.ViewHolder target) {
                    moveItem(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                    return true;
                }

                @Override
                public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                    deleteItem(viewHolder.getAdapterPosition());
                }
            };
    return simpleItemTouchCallback;
}
 private void moveItem(int oldPos, int newPos) {

    ListItem item = (ListItem) listData.get(oldPos);
    listData.remove(oldPos);
    listData.add(newPos, item);
    adapter.notifyItemMoved(oldPos, newPos);
}

private void deleteItem(final int position) {
    listData.remove(position);
    adapter.notifyItemRemoved(position);
}