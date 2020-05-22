@PreAuthorize("hasPermission(#book.company, write) or hasPermission(#book.company, admin)")
Book update(Book book, Map params = [:]) {    
  book.properties = params
  book.save(flush:true) 
  return book
}