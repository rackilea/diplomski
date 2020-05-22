@Service
public class HeroService {

  private final HeroRepository heroRepository;

  public HeroService(HeroRepository heroRepository) {
     this.heroRepository=heroRepository;
  }