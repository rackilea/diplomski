try {
    // code
} catch (IOException ioe) {
    // we expected this
    ioe.printStackTrace();
} catch (SomeOtherException soe) { // just an example...
    soe.printStackTrace();
} catch (Exception e) {
    // Did we expect this? Maybe not!
    e.printStackTrace();
}