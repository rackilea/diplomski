public void methodA() throws IOException {

    try {

        // methodWhichCanThrowIOException();

    } catch (IOException e) {

        // //perform operations before exits;
        throw e;
    }
}