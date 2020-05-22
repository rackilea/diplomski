while (scan1.hasNext()) {
    if (scan1.hasNextInt()) {
       // do something with int
    } else {
       // move past non-int token
       scan1.next();
    }
}