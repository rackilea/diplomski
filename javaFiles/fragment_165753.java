public class Library {

  private final Book[] bookArray;

  public Library(int maxBookCapacity){
    bookArray = new Book[libraryMaxBookCapacity];
  }

  public boolean inLibrary(Book book){
    for(int i = 0; i < bookArray.length; i++ ){
      if (book == bookArray[i]){
        return true;
      }
    }
    return false;
  }
}