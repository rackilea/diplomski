@Override
public Main getItem(int position) {
    return mFilteredData.get(position);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;
    if (convertView == null) {
        convertView = mInflater.inflate(R.layout.list_item, parent, false);
        holder = new ViewHolder();

        holder.title = (TextView) convertView.findViewById(R.id.item);
        holder.description = (TextView) convertView.findViewById(R.id.item_description);

        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    Main main = getItem(position);
    holder.title.setText(main.getContinent());
    holder.description.setText(main.getDescription());
    if (main.isSelected()) {
        convertView.setBackgroundColor(Color.parseColor("#1C3F96"));
        holder.title.setTextColor(Color.parseColor("#FFFFFF"));
        holder.description.setTextColor(Color.parseColor("#FFFFFF"));
    } else {
        convertView.setBackgroundColor(Color.TRANSPARENT);
        holder.title.setTextColor(Color.parseColor("#FFFFFF"));
        holder.description.setTextColor(Color.parseColor("#B5B5B5"));
    }

    return convertView;
}