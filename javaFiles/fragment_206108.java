public class how_to_play_skip_test {

    private RemoteWebDriver driver = null;
    private static final int MAX_ATTEMPTS = 10;

    @BeforeClass
    public void setup()throws Exception{

        int attempts = 0;
        boolean done = false;

        while ((MAX_ATTEMPTS > attempts) && !done) {
            try {
                this.driver = getDriver(config.desiredCapabilitites_galaxyss7());
                done = true;
            } catch (SessionNotCreatedException e) {
                System.out.println("Trying again...");
                //Maybe wait here some time?
            }
            attempts ++;
        }
    }

    private RemoteWebDriver getDriver() throws SessionNotCreatedException {
        if(capabilities == null){
            throw new IllegalArgumentException("Capabalities must not be null");
        }

        try {
            return new RemoteWebDriver(config.kobitonServerUrl(), config.desiredCapabilitites_galaxyss7());
        } catch(SessionNotCreatedException ex){
            System.out.println("Secondary device being used");
            return new RemoteWebDriver(config.kobitonServerUrl(), config.desiredCapabilitites_galaxys7())           
        }        
    }

    ...
}