@Override
public View getView(int position, View convertView, ViewGroup parent) {
View view = super.getView(position, convertView, parent);
TextView text = (TextView) view.findViewById(R.id.spinner);
text.setTextColor(Color.RED);
return view;
}