@RestController
public class RepoController {
    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    public Object getDocument(@PathVariable long id, HttpServletResponse response) {
       Object object = getObject();
       if( null == object ){
          response.setStatus( HttpStatus.SC_NO_CONTENT);
       }
       return object ;
    }
}