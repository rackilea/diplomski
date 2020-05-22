public class TaskViewHolder extends ChildViewHolder {
    private TextView mTextView;
    private CheckBox mCheckBox;
    private Boolean checkVal;
    private Button btnDelete;

    public TaskViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.exp_task);
        mCheckBox=itemView.findViewById(R.id.exp_task_checkbox);
        btnDelete = itemView.findViewById(R.id.btn_delete);

    }

    public void bind(final Routine parentRoutine, final int childIndex, final Tasks tasks, final ListActionListener listActionListener) {
        mTextView.setText(tasks.name);
        checkVal=((tasks.checkBox==1)?Boolean.TRUE:Boolean.FALSE);
        mCheckBox.setChecked(checkVal);
        //add delete button click
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listActionListener.onDeleteTaskClicked(parentRoutine, tasks, childIndex);
            }
        });

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                //to avoid initial call back
                if(checked != checkVal) {
                    listActionListener.onTaskCheckChanged(parentRoutine, tasks, childIndex, checked);
                    checkVal = checked;
                }
            }
        });
    }
}