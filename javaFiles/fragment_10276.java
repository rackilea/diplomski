try {
    baz();
    bar();
    foo(myInput);
} catch (BadUserInputException e) {
    reportError("Bad input: " + e.getMessage());
    log.info("recorded bad user input", e);
}