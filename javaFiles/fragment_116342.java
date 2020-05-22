@Override 
public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;

    if (convertView == null) {
        view = this.inflater.inflate(R.layout.list_row, null);
    }

    TextView taskName = (TextView) view.findViewById(R.id.taskName);
    String task = this.tasks.get(position);
    taskName.setText(task);

    return view;
}