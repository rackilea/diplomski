@Override
public View getView(int position, View convertView, ViewGroup parent) {
    final View listView;
    final LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    if (convertView == null) {
        listView = inflater.inflate(R.layout.list_item, null);
    } else {
        listView = convertView;
    }

    TextView textView = (TextView) listView.findViewById(R.id.listItem);

    String tile = keyArray.get(position) + " -- " + getItem(position);
    textView.setText(tile);
    Log.i("getView Text Is", tile);

    return listView;
}