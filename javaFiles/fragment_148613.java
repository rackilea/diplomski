private static void safeInsert(DBCollection c, DBObject o) {
    if (c == null) {
        throw new RuntimeException("collection must not be null");
    }

    if (o == null) {
        throw new RuntimeException("object must not be null");
    }

    try {
        c.insert(o);
    } catch (NullPointerException e) {
        throw new RuntimeException("unable to connect to MongoDB " + c.getFullName(), e);
    }
}