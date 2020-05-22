public boolean checkISBN(Book b){
    boolean isbnExists = false;
    for (Book bList : bookList)
    {
        if(**bList.equals(b)**){
            System.out.println("Book ISBN already exist");
            isbnExists = true;
        }
    }
    return isbnExists;  
}