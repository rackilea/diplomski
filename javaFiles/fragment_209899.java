@Component 
public class YourBean { 
    @Autowired
    public YourBean(@Value("${prop1}") String arg1, @Value("${prop2}") String arg2) { 
        // rest of the code
    } 
}