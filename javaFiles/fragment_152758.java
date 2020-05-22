public static List<Book> getList(String file) {
// create a new list of books
    List<Book> books = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        while (reader.ready()) {
            // read line of reader
            String bookLine = reader.readLine();
            Book book = toBook(bookLine);
            if (book != null) { //only add the book if it is non empty
                books.add(book);
            }
        }
        System.out.println();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return books;
}

private static Book toBook(String bookLine) {
    String[] bookParts = bookLine.split(",");
    if (bookParts.length < 3) { //validate if all three parts are present
        System.err.println(String.format("The line %s did not contain all parts", bookLine));
        return null;
    }
    if (bookParts[0].trim().isEmpty()) { // validate the book has a title
        System.err.println(String.format("The line %s did contain an empty title", bookLine));
        return null;
    }

    if (bookParts[1].trim().isEmpty()) { // validate the book has an author
        System.err.println(String.format("The line %s did contain an empty author", bookLine));
        return null;
    }
    if (!bookParts[2].trim().matches("\\d{4}")) { // checks if the year (3rd part is a number. Where \\d is for numeric and {4} means 4 digits)
        System.err.println(String.format("The line %s did contain a non-numeric value as year", bookLine));
        return null;
    }
    return new Book(bookParts[0], bookParts[1], Integer.parseInt(bookParts[2]));
}