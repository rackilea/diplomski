public interface Presenter<T> {
  void onAddButtonClicked();
  void onDeleteButtonClicked();
  void onItemClicked(T clickedItem);
  void onItemSelected(T selectedItem);
}