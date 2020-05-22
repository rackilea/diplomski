public interface Parser {
   //public methods that you need to call
}

public interface AutoMateParser extends Parser {
    //any extra or overriden method declarations
}

public abstract class AbstractParser implements Parser {
    //common code and implemented methods
    protected abstract Vehicle parseCar(String carData);
}

public class AutoMateParserImpl extends AbstractParser implements AutoMateParser {
    //any extra or overriden method implementations defined in AutoMateParser
    protected Vehicle parseCar(String vehicleData) {
        ...
    }
}

public class DMSServiceLocator {

    @Inject
    private AutoMateParser autoMateParser;
    //more services

    public Parser getParser() {
        if(automate) {
           return autoMateParser();
        } else {
           //Different data scrubber, but also extends Parser
           return homenetParser();
        }
    }

}