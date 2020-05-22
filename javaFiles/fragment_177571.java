public void checkIn(String ISBN)
    for(Book b : booklist)
    {
       if(b.getIsbn().equals(ISBN))
       {
           b.setCheckoutDate("");
           break;
       }
    }
}