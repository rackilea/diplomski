package BookShelf;

import java.util.Scanner;
import java.util.Arrays;
  /**
   * this class adds a book object and adds them to a book shelf
   * @author H
   * @verison 9/30/2017
   */
  public class BookShelf {
  Scanner scan;
  static final int MAX_SIZE = 25;
  int index;
  String[] books;

  public BookShelf() {
      //In the constructor, initialize the array and the index.
      //it's best practice not to initialize resources like scanner 
      //you may forget to close them.
      books = new String[MAX_SIZE];
      index = 0;
  }
/**
 * method that adds a book to the array
 * @return String, has new added book info in it
 */

public void addBook() {
  //Check you have room for the book you want to add.
  if (index == MAX_SIZE) {
      System.out.println("There are "+MAX_SIZE+" in the book shelf");
  } else {
      this.scan = new Scanner(System.in);
      System.out.println("Please enter the author's last name.");
      String line1 = scan.nextLine();
      System.out.println("Please enter the author's first name.");
      String line2 = scan.nextLine();
      System.out.println("Please enter the book title.");
      String line3 = scan.nextLine();
      System.out.println("Please enter the publisher.");
      String line4 = scan.nextLine();
      System.out.println("Please enter the publication year.");
      String line5 = scan.nextLine();
      String book =  line1 + ", " + line2 + " (" + line5 + ")" + ". " + line3 + ". " + line4;
      System.out.println("Added book: " + book);
      books[index] = book;
      index++;

      //Close the scanner
      scan.close();
  }
}  

public void printBooks() {
  for( int i = 0; i < books.length; i++){
    System.out.println(books[i]);
  }
}

/**
* method that asks user for a command and then follows the command
* follows the command by calling other methods
*/
public void interact(){
  Scanner scan = new Scanner(System.in);
  String answer = scan.nextLine();
  while (!answer.equalsIgnoreCase("quit")) {
    System.out.println("Would you like to add, print, or quit?");
    answer = scan.nextLine();
    if (answer.equalsIgnoreCase("add")) {
      addBook();
    }
    else if (answer.equalsIgnoreCase("print")) {
      printBooks();
    }
  }
  scan.close();
}

/**
 * main method
 * @param rank valid values: args
 */
    public static void main(String[] args){ 
      BookShelf bs = new BookShelf();  //makes new shelf
      bs.interact(); //interacts with shelf
    }
}