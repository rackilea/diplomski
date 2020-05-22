public View getView(int position, View convertView, ViewGroup parent) {

     LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     View itemView = inflater.inflate(groupid, parent, false);
     String[] row_items=records.get(position).split("__");
     TextView textName= (TextView) itemView.findViewById(R.id.pro_name);
     textName.setText(row_items[0]);
     TextView textPrice= (TextView) itemView.findViewById(R.id.pro_uprice);
     textPrice.setText(row_items[1]+"$");
     return itemView;
}