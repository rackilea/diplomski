public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    if(convertView == null) {
        convertView = inflater.inflate(R.layout.myrowlayout, parent, false);
    }

    TextView textView1 = (TextView) rowView.findViewById(R.id.textview1);
    TextView textView2 = (TextView) rowView.findViewById(R.id.textview2);
    TextView textView3 = (TextView) rowView.findViewById(R.id.textview3);
    TextView textView4 = (TextView) rowView.findViewById(R.id.textview4);

    // Set the text of the textViews accordingly to where you are in the list.
    // An example
    if(position % 2 == 0) {
        // If even position in the list, set the first TextView
        textView1.setText("This text is only shown for even positions in your list");            
    }

    return rowView;
}