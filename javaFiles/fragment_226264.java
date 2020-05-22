@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    View view = convertView;
    if (view == null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.listview_search_result, null);
    }

    final TextView listItemText = (TextView)view.findViewById(R.id.lv_sr_item);
    listItemText.setText(list.get(position));

    Button addBtn = (Button)view.findViewById(R.id.lv_sr_btn_add);
    addBtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            onAddListener.onAdd(position, listItemText.getText().toString());
        }
    });

    return view;
}