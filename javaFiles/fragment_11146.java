@BindingType(JSONBindingID.JSON_BINDING)
  public class MyService {
    public Book get(@WebParam(name="id") int id) {
      Book b = new Book();
      b.id = id;
      return b;
    }

    public static final class Book {
      public int id = 1;
      public String title = "Java";
    }
  }