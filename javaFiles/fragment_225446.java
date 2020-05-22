@Override
public boolean onMove(RecyclerView recyclerView,
                      RecyclerView.ViewHolder viewHolder,
                      RecyclerView.ViewHolder target) {
    final int fromPosition = viewHolder.getAdapterPosition();
    final int toPosition = target.getAdapterPosition();
    rearrangeTasks(fromPosition, toPosition);

    // Do not call background thread to update database.
    // new UpdateDatabaseTask(mTaskList).execute();

    // Keep a local ArrayList and keep the track of dragging the item. 
    updateLocalArrayListWhichIsBindToRecyclerView(mTaskList);
    return true;
}

@Override
public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    int position = viewHolder.getAdapterPosition();
    Task taskToDelete = mTaskAdapter.mTasks.get(position);
    // TaskLab.get(getActivity()).deleteTask(taskToDelete);
    updateLocalArrayListWhichIsBindedToRecyclerView(taskToDelete);
    updateUI(position);
}