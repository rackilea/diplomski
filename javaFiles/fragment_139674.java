LinkedList<Book> bookList = new LinkedList<Book>();

    double avg = 0.0;
    int counter = 0;
    for (Book b : bookList) {
        if (b.equals(inputBook)) { // must override hashCode() and equals in
                                    // Book and it should be independent of
                                    // price
            avg += b.price;
            counter++;
        }
    }
    return avg / counter;