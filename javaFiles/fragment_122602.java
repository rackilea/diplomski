@RestController
public class HeroController {

  private final HeroService heroService;

  public HeroController(HeroService heroService) {
    this.heroService=heroService;
  }