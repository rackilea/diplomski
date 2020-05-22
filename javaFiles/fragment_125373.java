public class SomeService {

    @Autowired 
    private List<Parser> parsers;

    public doSomethingWithParser(...) {
        ...
        Parser parser = getParser(JsonParser.class);
        parser.parse(...);
        ...
    }

    private Parser getParser(Class<Parser> targetClass) {
        Parser result = null;
        for(Parser parser : parsers) {
            if(parser.getClass().equals(targetClass)){
                result = parser;
            }
        }
        return transformer;
    }

}