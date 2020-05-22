@PostMapping("/books/view")
public String wwnewBook(@ModelAttribute Book book, Model model)
{
model.addAttribute("newAddedBook", book);
    System.out.println(book.getAuthor() + " || " + book.getTitle()); //     IT WORKS - I GET DATA I TYPE
    return "result";
}