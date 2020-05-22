@Override
public View getView(int position, View convertView, ViewGroup parent){
    TextView textView = (TextView) super.getView(position, convertView, parent);
    textView.setText("Hello, world!");
    // -or-
    textView.setText("whatever ...");

    return textView;
}