void myRoutine() throws SpecificException { 
    try {
        methodThrowingDifferentExceptions();
    } catch (SpecificException se) {
        throw se;
    } catch (Exception e) {
        //default routine for all other exceptions
    }
}