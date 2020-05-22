@Component
public class Service {

    @Autowired
    private ErrorCode errorCode;


    public void accessErrorCode() {
        System.out.println(errorCode.getCode()); //Print code property
        System.out.println(errorCode.getMessage()); //print message property
    }

}