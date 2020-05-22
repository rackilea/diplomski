@Component 
public class MyBean { 
    @Autowired
    public MyBean(@Value("${prop1}") String arg1, @Value("${prop2}") String arg2) { 
        // ... 
    } 
}