@Override
    public View getView(int position, View view, ViewGroup parent)  {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item_row, parent, false);
        }
        Store store = getItem(position);
        // use findViewById() to get the TextViews
        TextView name = (TextView) view.findViewById(R.id.txtName);
        // call setText using the values from store
        name.setText(store.getName());

        return view;
    }