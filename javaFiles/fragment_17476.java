public class UserAdapter extends ArrayAdapter<User> {

public UserAdapter(Context context, int resource) {
    super(context, resource);
}

public UserAdapter(Context context, List<User> values) {
    super(context, R.layout.list_item_pagination, values);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;

    if (row == null) {
        LayoutInflater inflater =
                ( (LayoutInflater)
                        getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        row = inflater.inflate(R.layout.list_item_pagination, parent,
                false);
    }
    TextView textView = (TextView)
            row.findViewById(R.id.list_item_pagination_text);
    User item = getItem(position);
    String message = item.getName();
    textView.setText(message);

    return row;
}}