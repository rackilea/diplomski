class Book {
  @Override
  public void finalize() {
    System.out.println("Book instance is getting destroyed");
  }
}

class Demo {
  public static void main(String[] args) {
    new Book();//note, its not referred by variable
    System.gc();//gc, won't run for such tiny object so forced clean-up
  }
}