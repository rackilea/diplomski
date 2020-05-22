public boolean DeleteWithIsbn(String isbn) {
    int index = 0;
    for (Book vivlio : books) {
        if(vivlio.getIsbn().equalsIgnoreCase(isbn)) { //find the right book
            for (int i = index; i < books.length - 1; i++) {
                books[i] = books[i+1]; //move all the other books up
            }
            books[books.length -1] = null; //reset the last one in the array
            return true;
        }
        count++;
    }

    return false;
}