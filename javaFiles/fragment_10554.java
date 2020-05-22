public void borrowBook(String title) 
 {
    int found = 0;
    for (Book b : collection) 
    {
        if (b.getTitle().equals(title)) 
        {
           if (found == 0) 
    {
            found = 1;
        }
        if (!b.isBorrowed()) 
    {
            b.borrowed=true;
            found = 2;
            break;
        }
    }
}
    if (found == 0) {
        System.out.println("Sorry, this book is not in our catalog.");
    } else if (found == 1) {
        System.out.println("Sorry, this book is already borrowed.");
    } else if (found == 2) {
        System.out.println("You successfully borrowed " + title);
    }
}