boolean shouldFail = false;
try {
    callTheMethod();
    shouldFail = true;
}
catch (AssertionError e) {
    // expected
}
if (shouldFail) {
    fail();
}