if (c != null ) {
    if  (c.moveToFirst()) {
        do {
           ...

        } while (c.moveToNext());
    }
    c.close(); // move to here
}
// here, close() is outside of the if causing a NPE if c is null