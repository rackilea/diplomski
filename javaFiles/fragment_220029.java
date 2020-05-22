@Controller
@RequestMapping(value="/movies", produces="application/json)
public class MovieController{

    @RequestMapping(value="/", method=RequestMethod.GET)
    public MyResponseObject getMovies(){
        //you can return a POJO object if you are using a Jackson Mapper
        return new MyResponseObject("foo", "bar");
    }

}