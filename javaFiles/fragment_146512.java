import play.Application;
import javax.inject.Inject;
import javax.inject.Provider;

class YourController extends Controller {

    @Inject
    Provider<Application> app;


    public Result someMethod() {
        // (...)
        // File is placed in conf/Data.json
        InputStrem is = app.get().classloader().getResourceAsStream("Data.json");
        String json = new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n")); 
        return ok(json).as("application/json");    
    }
}