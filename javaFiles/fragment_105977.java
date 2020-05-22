@Before
public void init() {
    Author lewis = new Author("Lewis");
    Author mark = new Author("Mark");
    Author peter = new Author("Peter");

    Book spring = new Book("Spring in Action", new HashSet<>(asList(lewis, mark)));
    Book springboot = new Book("Spring Boot in Action", new HashSet<>(asList(lewis, peter)));

    bookRepository.save(Arrays.asList(spring, springboot));
}

@Test
public void findAll() {
    List<Book> books = bookRepository.findAll();
    assertThat(books).hasSize(2);
    for (Book book : books) {
        Set<Author> bookAuthors = book.getAuthors();
        assertThat(bookAuthors).isNotNull();
        assertThat(bookAuthors.size()).isGreaterThan(0);

        System.out.println(book);
        bookAuthors.forEach(System.out::println);
    }

    List<Author> authors = authorRepository.findAll();
    assertThat(authors).hasSize(3);
    for (Author author : authors) {
        Set<Book> authorBooks = author.getBooks();
        assertThat(authorBooks).isNotNull();
        assertThat(authorBooks.size()).isGreaterThan(0);

        System.out.println(author);
        authorBooks.forEach(System.out::println);
    }    
}