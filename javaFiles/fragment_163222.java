public enum CustomerType {

    Retail(.1, "Retail customer"),
    College(.2, "College customer"),
    Trade(.3, "Trade customer");

    private final double discountPercent;
    private final String description;

    private CustomerType(double discountPercent, String description) {
        this.discountPercent = discountPercent;
        this.description = description;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

}