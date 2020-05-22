public View getView(int position, View convertView, ViewGroup parent) {

    LayoutInflater inflater = activity.getLayoutInflater();
    View rowView = inflater.inflate(R.layout.item_layout, parent, false);
    rowView.setMinHeight(height/4);
    return rowView;
}