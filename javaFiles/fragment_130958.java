@RestController
    @RequestMapping(value="/book")
    public class BookController {

    @RequestMapping(method=RequestMethod.POST)
        public ResponseEntity<Void> save(@Valid @RequestBody Book book){
            //save book
        }
    }

   @Entity
   public class Book{
     @NotEmpty(message="msg")
     private String name;
   }