public enum AdCategoryType {

    ForSale(1),

    ForBuy(2),

    ForRent(4),

    WantingForRent(8),

    WorkIsWanted(16),

    WorkIsGiven(32);

    private final int value;

    AdCategoryType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}