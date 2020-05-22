class BuyerOrderCountStats {
    private int orderCount;

    // may still have getters and setters

    public void updateOrderCount(IntUnaryOperator op) {
        orderCount=op.applyAsInt(orderCount);
    }
}