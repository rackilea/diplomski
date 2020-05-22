public void addPosition(position) {
   // if position is not in list
   if (positions.indexOf(position) < 0) {
      positions.add(position);
   }
}

public void setItemClicked(position) {
   // finds clicked item
   if (collection.get(position) != null) {
      collection.get(position).setIsClicked(true);
   }
}