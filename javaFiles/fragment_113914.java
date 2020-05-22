package myLib;

class Book {
// Declare fields
byte iStatus;
int iPages;
String sTitle, sAuthor;
String sBorrowedBy, sReservedBy;
String sDueDate, sReturnDate;

public static final byte BORROWED = 0, AVAILABLE = 1, RESERVED = 2;

// Constructor
public Book(String Title, String Author, int Pages) {
    this.sTitle = Title;
    this.sAuthor = Author;
    this.iPages = Pages;
    this.iStatus = Book.AVAILABLE;
}

// Borrow method
//Remove the static keyword
//Refer to the remaining static variables like AVAILABLE OR BORROWED using Book and not this keyword.
 void borrowBook(String Borrower, String Due) {
    if(this.iStatus == Book.AVAILABLE) {
        this.sBorrowedBy = Borrower;
        this.sDueDate = Due;
        this.iStatus = Book.BORROWED;
    }
    else if(this.iStatus == Book.RESERVED && this.sReservedBy == Borrower) {
        this.sBorrowedBy = Borrower;
        this.sDueDate = Due;
        this.sReservedBy = "";
        this.iStatus = Book.BORROWED;
    }

    }
}