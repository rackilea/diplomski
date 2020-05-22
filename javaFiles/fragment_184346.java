@RestController
public class RepoController {
    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    public Object getDocument(@PathVariable long id) {
       Object object = getObject();
       if ( null == object ){
          return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
       }

       return object ;
    }
}