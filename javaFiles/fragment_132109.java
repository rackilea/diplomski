@Component
@Scope(value = "step")
public class RobotsquidwardReader implements ItemReader<ComplexType> {

    @Autowired
    private CustomObject customObject;

    @Override
    public ComplexType read() throws Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {
        if(customObject.getCustomObjectList() != null) {
            return customObject.getCustomObjectList.remove(0);
        } else {
            return null;
        }
    }
}