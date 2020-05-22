class Book {

    private String title;
    private String author;
    private String yearofPub;

    Book(String input) {
        title = input;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearofPub() {
        return yearofPub;
    }

    public void setYearofPub(String yearofPub) {
        this.yearofPub = yearofPub;
    }



}