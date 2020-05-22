switch(type) {
    case TYPE_ITEM:
        convertView = mInflator.inflate(android.R.layout.simple_list_item_1, null);
        holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
        break;
    case TYPE_CHECKBOX_ITEM:
        convertView = mInflator.inflate(android.R.layout.simple_list_item_multiple_choice, null);
        holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
        break;
}