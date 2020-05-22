Callable<?> task = new Callable<Void> () {
    public Void call() throws Exception {
        someCodeThatThrowsCheckedExceptions();
        return null;
    }
}