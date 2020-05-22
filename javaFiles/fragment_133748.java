try {
    Object x = items[myIndex];
}
catch (ArrayIndexOutOfBoundObject e) {
    //Do some processing e.g. output a message
    System.err.println("Naughty, naughty - " + myIndex + " is out of bounds";
    // and:or throws a potentially different exception
    throw new NoSuchElementException(e.message());
}