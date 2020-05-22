public class CustomAdapter extends BaseAdapter {
Context context;
List<String> textArray;
LayoutInflater inflater;

public RutinaAdapter(Context context, List<String> textarray) {
    this.context = context;
    inflater = LayoutInflater.from(context);
    this.textArray = textarray;

}

@Override
public int getCount() {
    return textArray.size();
}

@Override
public Object getItem(int position) {
    return textArray.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewGroup vg;

    if (convertView != null) {
        vg = (ViewGroup) convertView;
    } else {
        vg = (ViewGroup) inflater.inflate(R.layout.custom_row, null);
    }

    String text = textArray.get(position);

    final TextView text = ((TextView) vg.findViewById(R.id.text));

    return vg;
} }