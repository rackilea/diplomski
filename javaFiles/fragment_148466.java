//Book  
public class Book {
   private String bookName;
   private String authorName;
   //getters and setters
}

//Member will have a book (maybe multiple) associated with them  
public class Member {
     private Book[] bookArray;
     public Member (Book... books) {
         this.bookArray = books;
     }
}