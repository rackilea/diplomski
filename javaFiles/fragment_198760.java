@Component
public class JustToCheck {

    @Autowired
    private FF4j ff4j;

    public void log2() {
        if (ff4j.check("check-no-logging")) {
            System.out.println("hello2"); 
        } else {
            System.out.println("As check-no-logging is disable... do nothin");
        }
    }
}