public static class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        // You could append additional information like 
        // author, publisher, etc...
        return title;
    }
}