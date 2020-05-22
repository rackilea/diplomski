@Component
public class CountryBootstrap {

    @Autowired
    CountryService countryService;

    public CountryBootstrap() {

    }

    @Autowired
    public CountryBootstrap(CountryService countryService) {
        this.countryService = countryService;
    }

    public void run() {
        countryService.saveCountry(new Country("Deutschland", "DE"));
    }
}