public interface Book {

    String getAuthor();
    String getGenre();
    String getPageCount();
    String getWeight();
}

public interface EBook extends Book {
    // Oh no - ebooks don't have weight, so that should always return zero!
    // But it makes no sense to include it as an attribute of the interface.
}