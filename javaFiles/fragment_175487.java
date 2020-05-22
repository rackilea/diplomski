public class RoutineViewHolder extends GroupViewHolder implements View.OnClickListener {
    private TextView mTextView;
    private Button btnAdd;

    public RoutineViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.exp_routine);
        btnAdd = itemView.findViewById(R.id.btn_add);
        itemView.setOnClickListener(this);
    }


    public void bind(final Routine routine, final ListActionListener listActionListener) {
        mTextView.setText(routine.getTitle());
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listActionListener.onAddTaskClicked(routine);
            }
        });
    }
}