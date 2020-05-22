public class CustomListAdapter extends BaseAdapter {
    private Context activity;
    private LayoutInflater inflater;
    private List<UserObject> items;

    public CustomListAdapter(Context activity, List<UserObject> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);


        TextView name = (TextView) convertView.findViewById(R.id.name);

        // getting movie data for the row
        UserObject m = items.get(position);

        name.setText(m.name);

        return convertView;
    }

}