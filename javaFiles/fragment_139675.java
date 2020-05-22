LinkedList<Book> temporaryBookList = new LinkedList<Book>();

    for (Book b : bookList) {
        if (b.name.equals(inputBook.name) && b.author.equals(inputBook.author)) { 
            temporaryBookList.add(b);
        }
    }

    double avg = 0.0;
    for(Book b : temporaryBookList){
        avg += b.price;
    }
    return avg / temporaryBookList.size();