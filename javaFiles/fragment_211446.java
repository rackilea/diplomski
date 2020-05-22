//setting data into the the ViewHolder.
    holder.title.setText(RowData.getName());
    holder.checked.setChecked(RowData.isChecked());

    //return the row view.
    return convertView;