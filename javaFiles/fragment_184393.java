public static class Book {
    //instance data members 

    protected static final NumberFormat FORMATTER = NumberFormat.getCurrencyInstance();
    //...

    @Override
    public String toString() {
        String str = "Book title:" + title + ", author:" + author
                        + ", pages:" + pages + ", price: " + FORMATTER.format(price);
        return str;
    }
}