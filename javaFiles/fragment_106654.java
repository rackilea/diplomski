public static class Library extends ArrayList<Book> {
    // Adding an overload remove method that accepts a String
    public void remove(String book) {
        // Find the book to remove
        for (int i = 0; i < size(); i++) {
            if (get(i).getTitle().equals(book)) {
                // This remove() is one of the default remove methods
                // that is part of an ArrayList
                remove(i);
                break;
            }
        }
    }

    // This will display "Titles: " once along with every
    // book in the ArrayList
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Titles: ");
        // Append each book to the returning String
        forEach(book -> sb.append(book).append("\n"));
        return sb.toString();
    }
}