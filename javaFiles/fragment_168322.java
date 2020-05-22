public void doSomething() {
    try {
        int x = libraryThing.badMethod(); //Library method that throws "Exception"
    }
    catch(Exception ex) {
        throw new RuntimeException("Couldn't do something", ex);
    }
}