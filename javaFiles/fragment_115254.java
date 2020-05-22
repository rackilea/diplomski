public boolean remove(StockItem item) {
    if (item != null && stock != null && stock.size() != 0)
        return stock.remove(item);
    else
        return false;
}