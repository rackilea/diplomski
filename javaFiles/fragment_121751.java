@Override
public View getDropDownView(int position, View convertView,ViewGroup parent) {
    return getCustomView(position, convertView, parent);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    return getCustomView(position, convertView, parent);
}

public View getCustomView(int position, View convertView, ViewGroup parent) {
     Textview circle;
     if (convertView == null) {
         convertView = inflater.inflate(R.layout.color_spinner_row, parent, false);
         circle = convertView.findViewById(R.id.circle);
         convertView.setTag(circle);
     } else {
         circle = (TextView) convertView.getTag();
     }
     // Do everything you want with  "circle"


     return convertView;
}