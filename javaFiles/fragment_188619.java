public void runGenericForXSeconds(BooleanSupplier supplier, int seconds) throws SOMEEXCEPTION {
    int timeout = currentTime + seconds; // milliseconds
    while (currentTime < timeout) {
        if (supplier.getAsBoolean())
            return; // if true exits the method, for the rest of the program, we are all good
    }
    throw new SOMEEXCEPTION("something failed"); // the function failed
}