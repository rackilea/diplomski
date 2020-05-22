try {
    ....
}
catch (SomeException ex) {
    throw new MyException ("some message", ex);
}