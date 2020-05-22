@RestController
@RequestMapping 
public class BiographyController {

  @Autowired
  private BiographyRepository biographyRepository;

  @RequestMapping(value = "/biography, method = RequestMethod.POST)
  public @ResponseBody
  Response create (HttpServletRequest request) {
    //read biography object from the request
    biographyRepository.save(biography);
  }

  //other methods...
}