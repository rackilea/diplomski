public class Driver
{
    public static void main(String[] args)
    {
        Book[] myBooks = { new Book("A"), new Book("B"), new Book("C"), new Book("D"), new Book("E")};
        ArrayList<Book> bookPiles = new ArrayList<Book>();
        System.out.println("Are there any books in the pile? " + bookPiles.isEmpty());

        for (int index = 0; index < myBooks.size(); index++)
        {
            Book nextItem = myBooks[index];
            bookPiles.add(nextItem);//populating ArrayList
        } // end for

        System.out.println("\nTotal books in the pile:");

        for (int index = 0; index < myBooks.size(); index++) 
        {
            System.out.println(bookPiles.get(index));
        } // end for

        System.out.println("\nRemoving the last book:");
        bookPiles.remove(bookPiles.size()-1); //removing the last element from the bookPile ArrayList
        //Object[] arr = (bookPiles.toArray()); //No need for this line

        for (int index = 0; index < bookPiles.size(); index++) 
        {
            System.out.println(bookPiles.get(index));
        } // end for

        System.out.println("\nAdding new book on top of the pile:");
         // you can write the code for adding at the top of the pile as follows:

        bookPiles.add(0,new Book("E"));//0 is the first position in the ArrayList where we want to add data and all the elements will be shifted automatically.
        //the above line will add the new book at the top of the pile.
        for (int index = 0; index < bookPiles.size(); index++) 
        {
            System.out.println(bookPiles.get(index)); //print all the books along with the new one
        } 


    }
}