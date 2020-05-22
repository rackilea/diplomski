sc = new Scanner(System.in);
    while(true){
    System.out.print("Enter title: ");
    title = sc.nextLine( );
           System.out.println();
    System.out.print("Enter isbn: ");
    isbn = sc.nextInt( );
    System.out.println();
    System.out.print("Enter quantity: ");
    quantity = sc.nextInt( );
    System.out.println();   

 // WRITE YOUR VALIDATION CODE HERE 
 // Change condition according to your requirements.
    if(isbn !=0 && quantity != 0 && title != null && title != "")
    {
        oneBook = new Book(title, isbn, quantity);
    bookList.add(oneBook); //create a list in main
    System.out.println("Book added in the list."); 
    }
    else 
    {
        System.out.println("Book not added");
         break;
       }

}
  for(int i = bookList.size()-1; i >= 0; i--){
    System.out.println(bookList.get(i));
    }