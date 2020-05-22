public abstract class Item {

    private String ItemId;
    private double ItemCost;
    private double ItemSellPrice;
    private boolean ItemSold;

    public Item(String ItemId, double ItemCost) {
        this.ItemId = ItemId;
        this.ItemCost = ItemCost;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    public double getItemCost() {
        return ItemCost;
    }

    public void setItemCost(double ItemCost) {
        this.ItemCost = ItemCost;
    }

    public double getItemSellPrice() {
        return ItemSellPrice;
    }

    public void setItemSellPrice(double ItemSellPrice) {
        this.ItemSellPrice = ItemSellPrice;
    }

    public boolean isItemSold() {
        return ItemSold;
    }

    public void setItemSold(boolean ItemSold) {
        this.ItemSold = ItemSold;
    }

}