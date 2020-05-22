@Controller 
public class ControllerB {
    @Autowired
    private ControllerA controllerA;

    ....
    public Object bMethod() {
        // do whatever you need to here
        return controllerA.aMethod();
    }