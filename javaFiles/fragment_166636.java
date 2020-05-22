public class ListAdapter extends ArrayAdapter<String> {
LayoutInflater inflater;

public ListAdapter(Context context, int textViewResourceId,
        List<String> objects) {
    super(context, textViewResourceId, objects);
    inflater = LayoutInflater.from(context);

}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    String str_value = this.getItem(position);
    if (convertView == null) {
        convertView = inflater.inflate(R.layout.list_item, null);
    }
    TextView tv = (TextView) convertView.findViewById(R.id.textView1);
    tv.setText(str_value);
    return convertView;
}

}