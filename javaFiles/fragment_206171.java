public class TodoAdaptor extends RecyclerView.Adapter<TodoAdaptor.SingleTodoView> {
    private boolean darkTheme;
    private Context context;
    private ArrayList<SingleTodo> todoList;
    private onItemCLickListener itemCLickListener;

    public TodoAdaptor(Context context, ArrayList<SingleTodo> todoList, boolean darkTheme, onItemCLickListener onItemClickListener) {
        this.darkTheme = darkTheme;
        this.context = context;
        this.todoList = todoList;
        this.itemCLickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public SingleTodoView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_todo, parent, false);
        return new SingleTodoView(v, itemCLickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleTodoView holder, int position) {
        SingleTodo singleTodo = todoList.get(position);
        holder.checkbox.setChecked(singleTodo.isComplete());
        holder.title.setText(singleTodo.getTitle());
        if (singleTodo.isComplete()) {
            holder.title.setPaintFlags(holder.title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.title.setPaintFlags(holder.title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }
        if (singleTodo.getDueDate().isEmpty()) {
            holder.dueDate.setVisibility(View.GONE);
        } else {
            holder.dueDate.setVisibility(View.VISIBLE);
            holder.dueDate.setText(singleTodo.getDueDate());
        }
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    class SingleTodoView extends RecyclerView.ViewHolder {

        private CheckBox checkbox;
        private TextView title, dueDate;
        private SingleTodoView(@NonNull View itemView, final onItemCLickListener itemCLickListener) {
            super(itemView);
            checkbox = itemView.findViewById(R.id.todo_list_completed_checkbox);
            title = itemView.findViewById(R.id.todo_list_title);
            dueDate = itemView.findViewById(R.id.todo_list_due_date);
            if (darkTheme) {
                title.setTextColor(context.getResources().getColor(R.color.colorLightGray));
                dueDate.setTextColor(context.getResources().getColor(R.color.colorLightGray));
            } else {
                title.setTextColor(context.getResources().getColor(R.color.colorBlack));
                dueDate.setTextColor(context.getResources().getColor(R.color.colorBlack));
            }

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemCLickListener.onTextClickListener(getAdapterPosition());
                }
            });
            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemCLickListener.onCheckboxClickListener(getAdapterPosition());
                }
            });
        }
    }

    public interface onItemCLickListener {
        void onTextClickListener(int position);

        void onCheckboxClickListener(int position);
    }
}