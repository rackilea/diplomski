@Entity
@Table(name = "Book")
public class Book {
  @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="book")
  private Collection<Author> authors;
  // ...
}

@Entity
public class Author {
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="book_id")
  private Book book;
  // ...
}