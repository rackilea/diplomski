static class ViewHolder {
    ImageView itemAvatar;
    TextView itemName;
    TextView itemId;
}

public ItemsAdapter (List<YourObjectName> yourObjectsList) {
    this.yourObjectsList = yourObjectsList;
}

@Override
public int getCount() {
    return yourObjectsList.size();
}

@Override
public YourObjectName getItem(int position) {
    return yourObjectsList.get(position);
}

@Override
public long getItemId(int position) {
    return yourObjectsList.get(position).id;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    final ViewHolder viewHolder;
    if (convertView == null) {
        final LayoutInflater inflater = LayoutInflater.from(Controller.getContext());
        convertView = inflater.inflate(R.layout.item_layout, parent, false);

        viewHolder = new ViewHolder();
        viewHolder.itemAvatar = (ImageView) convertView.findViewById(R.id.avatar_item);
        viewHolder.itemName = (TextView) convertView.findViewById(R.id.name_item);
        viewHolder.itemId = (TextView) convertView.findViewById(R.id.id_item);

        convertView.setTag(viewHolder);
    } else {
        viewHolder = (ViewHolder) convertView.getTag();
    }

    YourObjectName itemAtPosition = yourObjectsList.get(position);
    viewHolder.itemAvatar.setImageBitmap(itemAtPosition.bitmap);
    viewHolder.itemName.setText(itemAtPosition.name);
    viewHolder.itemId.setText(itemAtPosition.id);

    return convertView;
}