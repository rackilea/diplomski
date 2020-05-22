String strArray[] = new String[<size of Your ListView>]; 

@Override
public View getView(int position, View convertView, ViewGroup parent) {


    TextView textView;
    if (convertView == null) {

        convertView = inflater.inflate(R.layout.listitem, parent, false);
        textView = (TextView) convertView
                .findViewById(R.id.textView);
    }
    strArray[position] = textView.getText().toString();
    return convertView;
}