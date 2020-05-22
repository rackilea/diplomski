public void onItemMove(int oldPosition, int newPosition) {
    notifyItemMoved(oldPosition,newPosition);

}

 public void onItemDismiss(int adapterPosition) {
  /// here you can delete from the array and notify for that specific position
 }