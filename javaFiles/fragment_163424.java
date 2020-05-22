List<Book> books = new ArrayList<Book>();
    while(!answer.equals("stop"))
        {
        //Enters book's information  and stores it in the object book1  
        System.out.println("Book-" + count);    

        title = input.next();
        author = input.next();
        ISBN = input.next();
        copies = input.nextInt();

        Book book1 = new Book(title,author, ISBN, copies);
        books.add(book1);

        printLn("");
        printLn("Do you wish stop adding books? N || stop");      
        answer = input.next();
     }

     //Iterating the book list outside the loop
     for(Book book:books){
       //this call may vary depending on the book implementation
       System.out.println(book.getTitle());
     }