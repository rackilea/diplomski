private int findBook(String isbn){
    // iterate all the Book elements in the collection array
    for(int i = 0; i <= collection.length; i++){
        // check if the current book isbn matches the one provided argument
        if (collection[i].getIsbn().equals(isbn))
            return i;
    }
    return -1;
}