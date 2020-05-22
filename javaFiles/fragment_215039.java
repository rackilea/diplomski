@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    Holder holder=new Holder();
    View rowView;
    rowView = inflater.inflate(R.layout.rowlayout2, null);
    holder.name =(TextView) rowView.findViewById(R.id.EditTextName);
    holder.address =(TextView) rowView.findViewById(R.id.EditTextAddress);
    holder.ib = (ImageButton) rowView.findViewById(R.id.Delete);
    holder.name.setText(n[position]);
    holder.address.setText(a[position]);
    holder.ib.setTag(convertView);

    //Add this for on-click of delete button
    holder.ib.setOnClickListener(new OnClickListener(){
         //Delete the row in your data source specified at position

    });

    rowView.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Toast.makeText(context, "You Clicked "+n[position], Toast.LENGTH_LONG).show();
        }

    });
    return rowView;
}