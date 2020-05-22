private View inflateEditRow(String string) {
        LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_view, myLayout, false);
        row = inflater.inflate(R.layout.my_wallet_items, parent, false);
        viewHolder = new MyWrapper(row);
        row.setTag(viewHolder );

        TextView tv = (TextView) row.findViewById(R.id.TextView1);
        tv.setText(string);
        Log.i("Law", "string " + row.getId());
        return row;
    }