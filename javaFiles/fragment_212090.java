@Bean
public CommandLineRunner dataInitializer(BookRepository br) {
    return new CommandLineRunner() {
        public void run (String... args) throws Exception {
            // initialize bookRepository
            Book book = new Book.BookBuilder("W pustyni i w puszczy", "Henryk Sienkiewicz").pages(400).build();
            Book book1 = new Book.BookBuilder("Dziady IV", "Adam Mickiewicz").pages(300).build();
            Book book2 = new Book.BookBuilder("Krzyzacy", "Henryk Sienkiewicz").pages(900).build();

            bookRepository.save(book);
            bookRepository.save(book1);
            bookRepository.save(book2);
        }
    };
}