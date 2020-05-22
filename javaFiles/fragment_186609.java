public Void call() throws Exception {
    try {
        ThirdParty.doSomething();
    } catch(SomeTypeException e) {
        SomeErrorHandler.handleThisError(e); // E.g. report it to the user
    }
    return null;
}