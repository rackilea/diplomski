void selectGroup(Group group){
  for(Item item: group.getItems()){
      item.isSelected = true;
  }

  //update your list
  notifiDataSetChanged();
}