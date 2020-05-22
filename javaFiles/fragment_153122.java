@Service // or any other Spring managed bean
public class SomeService {
    /**
     * After injecting the properties, you can use properties.getParam1()
     * to get the param1 value, which is defaults to val1
     */
    @Autowired private Properties properties; 

    // Other stuff
}