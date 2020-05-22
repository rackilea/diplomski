public class ExpandableAdapter extends ExpandableRecyclerViewAdapter<RoutineViewHolder, TaskViewHolder> {
    ListActionListener listActionListener;
    public ExpandableAdapter(List<? extends ExpandableGroup> groups, ListActionListener listActionListener) {
        super(groups);
        this.listActionListener = listActionListener;
    }

    @Override
    public RoutineViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_routine, parent, false);
        return new RoutineViewHolder(v);
    }

    @Override
    public TaskViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_task, parent, false);
        return new TaskViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(TaskViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Tasks tasks = (Tasks) group.getItems().get(childIndex);
        holder.bind((Routine)group, childIndex, tasks, listActionListener);
    }

    @Override
    public void onBindGroupViewHolder(RoutineViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Routine routine = (Routine) group;
        holder.bind(routine, listActionListener);

    }
}