class PackingListRow {
    private final String isbn;
    private final int palletNumber;
    private final int quantity;

    static class GroupPacking {

        private final String isbn;
        private final int palletNumber;

        public GroupPacking(PackingListRow p) {
            this.isbn = p.isbn;
            this.palletNumber = p.palletNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GroupPacking that = (GroupPacking) o;
            return Objects.equals(palletNumber, that.palletNumber) &&
                    Objects.equals(isbn, that.isbn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isbn, palletNumber);
        }
    }

    ....

    public PackingListRow merge(PackingListRow other) {
        assert (new GroupPacking(other).equals(new GroupPacking(this)));
        return new PackingListRow(this.isbn, this.palletNumber, this.quantity + other.quantity);
    }
}