Author[] authors = new Author[] {
    new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm'),
    new Author("Paul Tan", "Paul@nowhere.com", 'm')
};
Book b = new Book("name", authors, ...);
System.out.println(Arrays.toString(b.getAuthors()));