//... 
else {
    holder = (ViewHolder) convertView.getTag();
}
Note data = (Note) getItem(position);
switch (type) {
    case INITIAL_TYPE:
        // for the initial row extract whatever you want from the data object
        // like for example:
        holder.mText.setText(data.getNote());
        break;
    case CHANGE_TYPE:
        // for the second row type extract whatever you want from the data object
        // like for example: 
        holder.mText.setText(data.getNote());
        break;
}
return convertView;