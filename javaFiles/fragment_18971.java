@Controller
@RequestMapping( value="/stringreverser" )
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping( value="/{id}", method=RequestMethod.GET )
    public String reverseId( @PathVariable String id, Model model ) {

        StringBuilder reversed = new StringBuilder();
        for ( int i = id.length() - 1; i >= 0; i-- ) {
            reversed.append( id.charAt( i ) );
        }

        logger.debug( "\n\t [" + id + "] reversed ==> " + reversed.toString() );

        model.addAttribute( "originalId", id );
        model.addAttribute( "reversedId", reversed.toString() );

        return "home";
    }
}