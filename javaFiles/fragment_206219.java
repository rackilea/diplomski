int random;
    int i=0;
    for (LibraryBook book : bookStock ){
        i++;
        random = rnd.nextInt(n-1); // sets a new value in every loop
        book = bookStock[random];