/**
 * Parent fragment or activity to implement this interface to listen to item deletes.
 * Item deletes effect the state of the parent
 */
public interface OnItemModifiedListener {
    void itemDeleted(Cart.CartItem item);
    void itemQuantityChanged(Cart.CartItem item, int newQuantity);
    void itemRemovedAll();
}