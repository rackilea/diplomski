public class Book {

    @JsonView({BookViews.BookBrief.class, BookViews.BookPreview.class})
    private long id;

    @JsonView(BookViews.BookBrief.class)
    private String title;

    @JsonView(BookViews.BookPreview.class)
    private String annotation;

    // Constructors and getters/setters
}