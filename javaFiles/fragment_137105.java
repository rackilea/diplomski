@RestController
@RequestMapping(value="/animal")
public class AnimalController {

private final AnimalService animalService;

  @Autowired
  public AnimalController(AnimalService service) {
    animalService = service;
  }


  @GetMapping(value = "/{animal}/sound")
  public String animalSound(@PathVariable String animal) {
    return animalService.doSound(animal);
  }

}