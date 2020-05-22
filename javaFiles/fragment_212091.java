@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    @RequestMapping(method=RequestMethod.GET)
    public List<Book> addBasicBooks() {
        return bookRepository.listAll();
    }
}