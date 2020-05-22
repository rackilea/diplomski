private static class Entry {
    String[] row;

    public Entry ( ResultSet r ) {
        row = new String [ 7 ];
        for (int i = 1; i <= 7; i++) {
            row[i] = r.getString(i);
        }
    }
}