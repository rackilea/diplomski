@Override
public boolean onLongClick(View view) {
    workout.isCompleted = !workout.isCompleted;
    holder.setSelected(workout.isCompleted);
    return true;
}