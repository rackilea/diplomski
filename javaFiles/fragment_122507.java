try {
    DerbyNow derbyNow = new DerbyNow();

    setDerbyNow(derbyNow);
} catch (Exception e) {
    if (e instanceOf IOException) {
        Log.bad("error while setting up Derby Now: ", e);
    } else {
        throw e;
    }
}