public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = inflate(R.layout.item_row, parent, false);
    }

    return convertView;
}