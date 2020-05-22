public class DeadlineAdapter extends ArrayAdapter<String> {

    private Activity context;
    private List<String> deadlineList;

    public DeadlineAdapter(Activity context, List<String> deadlineList) {
        super(context, R.layout.item_deadline, deadlineList);
        this.context = context;
        this.deadlineList = deadlineList;
    }

    @NonNull
    public View getView(int position, View convertView, @NotNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.item_deadline, parent, false);

        TextView positionTv = listView.findViewById(R.id.row_id);
        TextView textTv = listView.findViewById(R.id.row_text);

        positionTv.setText(String.format("%s.", position + 1));
        textTv.setText(deadlineList.get(position));

        return listView;
    }
}