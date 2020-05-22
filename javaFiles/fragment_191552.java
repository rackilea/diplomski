@Override
public View getView(int position, View convertView, ViewGroup parent) {

    NewsHolder holder = null;
   LayoutInflater inflater = ((Activity)context).getLayoutInflater();
    int type = getItemViewType(position);

    switch (type) {
        case 1: {
            holder = new NewsHolder();
            if (convertView == null || (((NewsHolder) convertView.getTag()).getType() == 0)) {
                convertView = inflater.inflate(R.layout.section_header, null);
                holder.itemName = (TextView) convertView.findViewById(R.id.header);
                holder.setType(1);
                convertView.setTag(holder);
            } else {
                holder = (NewsHolder) convertView.getTag();
            }
            holder.itemName.setText("CUSTOM TEXT");

            break;
        }
        case 0: {
            holder = new NewsHolder();
            if (convertView == null || (((NewsHolder) convertView.getTag()).getType() == 1)) {
                convertView = inflater.inflate(R.layout.custom_row, null);
                holder.itemName = (TextView) convertView.findViewById(R.id.example_itemname);
                holder.icon = (ImageView) convertView.findViewById(R.id.example_image);
                holder.button3 = (Button) convertView.findViewById(R.id.swipe_button3);
                holder.setType(0);
                convertView.setTag(holder);
            } else {
                holder = (NewsHolder) convertView.getTag();
            }
            ItemRow itemdata = data.get(position);
            holder.itemName.setText(itemdata.getItemName());
            holder.icon.setImageDrawable(itemdata.getIcon());

            break;
        }
    }


    return convertView;
}