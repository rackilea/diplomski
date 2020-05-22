private OnClickListener listener= new OnClickListener() {
    @Override
    public void onClick(View v) {
        int position = ((Integer) v.getTag());

    }
};

 @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        ItemInList itemInList = getItemList(position);



        ((TextView) view.findViewById(R.id.id_item)).setText(itemInList.id);
        ((TextView) view.findViewById(R.id.name)).setText(itemInList.name);
        ((ImageButton) view.findViewById(R.id.imageButton)).setImageResource(itemInList.imageButton);

        ((ImageButton) view.findViewById(R.id.imageButton)).setTag(position);
        ((ImageButton) view.findViewById(R.id.imageButton)).setOnClickListener(listener);
        return view;

    }