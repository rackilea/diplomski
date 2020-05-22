enum Type {
    TYPE_A () {
        public Item createItem() {
            return new ItemType1();
        }
    },
    TYPE_B () {
        public Item createItem() {
            return new ItemType2();
        }
    },
    ...;
    public abstract Item createItem();
}