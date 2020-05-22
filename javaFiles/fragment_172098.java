public boolean addBook(aBook book){
   if(book != null){                // this is just an example but you know better than me of what your algorithm is.
     if(index < tempBooks.length){
       tempBooks[index] = book;
       index++;
       return true;
     }
   }
   return false; // return false otherwise
}