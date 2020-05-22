public class Library {

  public static void main(String [] args) {
    List<Book> library = new ArrayList<>();
    library.add(new Book("9780593098240", "Children of Dune"));
    library.add(new Book("9780593098233", "Dune Messiah"));
    library.add(new Book("9780441172719", "Dune"));
    // Just to show the sorting, based on multiple attributes.
    Collections.sort(library);
    System.out.println("Books in library: " + Arrays.toString(library.toArray()));

    // You would obviously have some code for entering a book here, but easier to just create the object for an example. 
    Book newBook = new Book("9780593098240", "Children of Dune");
    for (Book bookInLibrary : library) {
        if (bookInLibrary.compareTo(newBook) == 0) {
            System.out.println("We already have that book in the library.");
            break;
        }
    }
  }
}