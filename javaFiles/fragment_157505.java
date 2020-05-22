@RequestMapping(value = " /shoppingcart/{bookId}", method=RequestMethod.GET)
public String shoppingCart(@PathVariable("bookId")int bookId, Model model) {

  // This gets the currently logged in user
  Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
  String username = loggedInUser.getName(); // Authentication for 
  User user = userRepository.findByUsername(username);

  //Retrieve book
  Book book = bookService.findBookById(bookId);

  // This will add the book to the user's booklist
  user.saveBookToShoppingCart(book);

  return "shoppingcart";
}