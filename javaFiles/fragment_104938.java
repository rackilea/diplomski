public class CustomAdapter extends ArrayAdapter<Integer> {
    private ListView listView;

    public CustomAdapter(Context context, int textViewResourceId, Integer[] objects, ListView listView) {
        super(context, textViewResourceId, objects);
        this.listView = listView;
    }


    static class ViewHolder {
        TextView text;
        Button btn;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Integer color = getItem(position);

        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_view_row, parent, false);
            ViewHolder h = new ViewHolder();
            h.text = (TextView) rowView.findViewById(R.id.item_text);
            h.btn = rowView.findViewById(R.id.btn);
            rowView.setTag(h);
        }

        ViewHolder h = (ViewHolder) rowView.getTag();

        h.text.setText(color);
        h.indicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DO what you want to recieve on btn click there.
            }
        });

        return rowView;
    }
}