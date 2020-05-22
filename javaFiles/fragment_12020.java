class Item {

    public int id;
    public String imgUrl;
    public String title;

    @Override
    public String toString() {
        return this.id + "-" + this.title;
    }
}