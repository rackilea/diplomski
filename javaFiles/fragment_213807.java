public class ControllerWithInjectedDAO extends Controller {

    private final CountryDAO countryDAO;

    @Inject
    public ControllerWithInjectedDAO(final CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    public F.Promise<Result> getAllCountries() {
        return F.Promise.promise(() -> countryDAO.findAll())
                        .map(Json::toJson)
                        .map(Results::ok);
    }
}