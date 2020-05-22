@RestController
public class BooksRestController{

    @RequestMapping(value="/books/{bookName}/author", method=RequestMethod.GET)
    public Map<String,String> getAuthor(@PathVariable bookName){
        ...
        Map<String,String> author = new HashMap<String,String>();
        author.put("author",bookAuthor);
        return author;
    }
}