public boolean equals(Object o) {
         //below line is comparing if o refers to the same current object
         if (o == this) { return true; }
         //below line is checking if o is null, in that case it will return false
         if (o == null) { return false;}
         //checking if the class of o is Book, if not return false
         if (!o.getClass().equals(Book.class)) {return false; }
         //Casting the o from Object to Book class
         Book aBook = (Book) o;
         //comparing the book object's year. title and author, if all three are equal then only two Book objects are equal
         return aBook.year == year && aBook.title.equals(title) && aBook.author.equals(author);
     }