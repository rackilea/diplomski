getItemView(...){
  ...
  itemHolder.checkbox.setSelected(item.isSelected)
}

getGroupView(...){
  ...
  groupHolder.checkbox.setSelected(group.isSelected)

  //add lisener
  itemHolder.checkbox.setOnCheckedChangeListener(lisener);
}