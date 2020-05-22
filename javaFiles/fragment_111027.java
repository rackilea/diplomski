final class PriceAndQuantity {

    final double price;
    final double quantity;

    private PriceAndQuantity(final double price, final double quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    static PriceAndQuantity of(final double price, final double quantity) {
        return new PriceAndQuantity(price, quantity);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("quantity", quantity)
                .toString();
    }

}