final class Order {

    final long lastUpdateId = Long.valueOf(0); // if `0`, then javac inlines 0 everywhere
                                               // so we're kind of cheating
    final List<PriceAndQuantity> bids = null;
    final List<PriceAndQuantity> asks = null;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("lastUpdateId", lastUpdateId)
                .add("bids", bids)
                .add("asks", asks)
                .toString();
    }

}