public interface ListActionListener {
       // Know add was clicked on given routine
       void onAddTaskClicked(Routine routine);
       // Know delete was clicked on given task.
       void onDeleteTaskClicked(Routine routine, Tasks task, int index);
       // Know checkbox clicked on given task (with new checked status)
       void onTaskCheckChanged(Routine routine, Tasks task, int index, boolean checked);
}