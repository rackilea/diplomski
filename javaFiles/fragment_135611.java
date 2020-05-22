class Test {

   public static void main(String[] args) {

      Book b1 = new Book();
      b1.setYear(1975);
      b1.setTitle("The God and the Sword");
      System.out.println(b1);
      b1.setRead(true);
      System.out.println(b1);

      Book b2 = new Book();
      b2.setTitle("The Light of Spirind");
      b2.setYear(1960);
      System.out.println(b2);
      b2.setRead(true);
      System.out.println("The book has now been read: " + b2.isRead());
   }
}

class Book {

   private boolean read;
   private int year;
   private String title;

   public boolean isRead() {
      return read;
   }

   public void setRead(boolean read) {
      this.read = read;
   }

   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   Book() {

   }

   public String toString() {
      return "This Book\ntitle: " + getTitle() + ",\n " + "year of publication: " + getYear() + ",\n " + "read: " + isRead();
   }
}