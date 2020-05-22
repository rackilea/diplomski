public class AccountAdapter extends ArrayAdapter<ListParser> {
    public AccountAdapter(Context context, ArrayList<ListParser> users) {
        super(context, 0, users);
    }

    public static class ViewHolder {
        TextView accountName;
        TextView description;
        TextView balance;

        public ViewHolder(View convertView) {
             accountName = (TextView) convertView.findViewById(R.id.accountName);
             description = (TextView) convertView.findViewById(R.id.description);
             balance = (TextView) convertView.findViewById(R.id.balance);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ListParser user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.account_view, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // Lookup view for data population
        TextView accountName = viewHolder.accountName;
        TextView description = viewHolder.description;
        TextView balance = viewHolder.balance;
        // Populate the data into the template view using the data object
        accountName.setText(user.accountName);
        description.setText(user.description);
        balance.setText(user.balance);
        // Return the completed view to render on screen
        return convertView;
    }
}