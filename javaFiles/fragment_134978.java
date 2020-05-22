public void searchBookInCollection(String title) 
{
      boolean found = false;
      for (Book book : books)
      {
            if(book.getTitle().equalsIgnoreCase(title)) 
            {
               book.displayBookInformation();
               found = true;
               break;  // no point to keep going? 
            }
       }
       if (!found)
       {
           System.out.println("Nope we don't have it");
       }
}