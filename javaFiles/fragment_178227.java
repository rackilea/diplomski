class Kot implements Comparable<Kot> {

    private String productName;
    private Integer kotNo;

    public Kot() {
    }

    public Kot(String productName, Integer kotNo) {
        this.productName = productName;
        this.kotNo = kotNo;
    }

    @Override
    public int compareTo(Kot kot1) {
        int kotNoCompare = kot1.kotNo.compareTo(this.kotNo);
        if (kotNoCompare == 0) {
            int productNameCompare = kot1.productName.compareTo(this.productName);
            return productNameCompare;
        }
        return kotNoCompare;
    }
}