class PackingListRow {
    private final String isbn;
    private final int palletNumber;
    private final int quantity;

    public PackingListRow(String isbn, int palletNumber, int quantity) {
        this.isbn = isbn;
        this.palletNumber = palletNumber;
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPalletNumber() {
        return palletNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackingListRow that = (PackingListRow) o;
        return Objects.equals(palletNumber, that.palletNumber) &&
                Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, palletNumber);
    }

    @Override
    public String toString() {
        return "PackingListRow{" +
                "isbn='" + isbn + '\'' +
                ", palletNumber=" + palletNumber +
                ", quantity=" + quantity +
                '}';
    }

    public PackingListRow merge(PackingListRow other) {
        assert(this.equals(other));
        return new PackingListRow(this.isbn, this.palletNumber, this.quantity + other.quantity);
    }
}