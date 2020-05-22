// direct reference to the Country class
public class ControllerWithActiveRecord extends Controller {
    public F.Promise<Result> getAllCountries() {
        return F.Promise.promise(() -> Country.findAll())
                        .map(Json::toJson)
                        .map(Results::ok);
    }
}