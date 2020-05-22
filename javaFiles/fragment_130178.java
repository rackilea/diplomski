@RestController
@RequestMapping(value="/foo/")
public class Baz {

  @RequestMapping(value="bar/v1", method=RequestMethod.GET)
  public String doXyz() { 

  }
}