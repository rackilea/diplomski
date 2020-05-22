public class User {

    private Set<Book> books; //provide accessors

    ...
    public static User unionUser(User first, User second) {
      User result = new User();
      result.setBooks(first.getBooks().unionAll(second.getBooks());
      return result;
    }
    ...

 }