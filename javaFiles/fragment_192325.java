class PriceSetter {
    private Table priceTable;

    public PriceSetter(Dependency d1, Dependency d2) {
        this(d1, d2, new DefaultPriceTable());
    }

    PriceSetter(Dependency d1, Dependency d2, Table priceTable) {
        this.d1 = d1;
        this.d2 = d2;
        this.priceTable = priceTable;
    }

}