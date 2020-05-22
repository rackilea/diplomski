@RestController
public class BooksRestController{

    @RequestMapping(value="/books", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book){
        ...
        //save book
        book = bookService.save(book);
        return book;
        //Book is going to be serialized as JSON because of the implicit 
        //@ResponseBody annotation from @RestController
    }