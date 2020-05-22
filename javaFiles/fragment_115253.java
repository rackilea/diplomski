/**
 * 
 * @param index
 * @return null if index is invalid, otherwise remove item at the given
 *         index and return the removed item.
 */
public StockItem remove(int index) {
    if (index >= 0 && index < stock.size()) // check if this index exists
        return stock.remove(index); // removes the item the from stock   and returns it
    else
        return null; // The item doesn't actually exist
 }