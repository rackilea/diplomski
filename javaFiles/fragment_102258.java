public interface StockList {
    public void addItem(StockItem item); 
    public void deleteItemById(String itemID); 
    // Updates price of existing item
    public void updateItemPrice(String itemID, double price);
    /// etc.
}