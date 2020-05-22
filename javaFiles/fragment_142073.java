final int[] oldPos = new int[1];
final int[] newPos = new int[1];
ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(

        ItemTouchHelper.UP |
                ItemTouchHelper.DOWN |
                ItemTouchHelper.LEFT |
                ItemTouchHelper.RIGHT,
        0) {
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        oldPos[0] = viewHolder.getAdapterPosition();
        newPos[0] = target.getAdapterPosition();
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        moveItem(oldPos[0], newPos[0]);
    }
});


private void moveItem(int oldPos, int newPos) {
    Item temp = mItems.get(oldPos);
    mItems.set(oldPos, mItems.get(newPos));
    mItems.set(newPos, temp);
    mAdapter.notifyItemChanged(oldPos);
    mAdapter.notifyItemChanged(newPos);

}