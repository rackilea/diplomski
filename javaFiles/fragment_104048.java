public class Author {
    @JsonBackReference
    private Book book;
}

public class Book {
    @JsonManagedReference
    private List<Author> authors = new ArrayList<Author>();
}