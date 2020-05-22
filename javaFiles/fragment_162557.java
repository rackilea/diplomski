private static class Entry {
    String column1; // rather than name column1 use what the column semantically represents

    String column2;

    // ...

    public Entry ( ResultSet r ) {
        column1 = r.getString(1);
        // ...
    }