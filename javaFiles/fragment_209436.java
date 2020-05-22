@GetMapping("/books/delete")
public String deleteBook(Model model, HttpSession session) {
    session.setAttribute("BookList", new Book[]{
            new Book("Title", "Tom","genre"),
            new Book("Title 2", "Jerry","genre2")}
    );
    return "delete";
}

@PostMapping("/books/delete")
public String deletedBook(HttpSession session, Integer id, Model model) {
    Book[] books = (Book[]) session.getAttribute("BookList");
    Book book = books[id];
    System.out.println(book); 
    model.addAttribute("deletedBook", book);
    return "deletedBookResult";
}