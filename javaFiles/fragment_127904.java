@Service("myService")
public class MyService extends CommonStuff {
    @Value("${myProperty.myField}")
    private String myField;

    @Override
    public String getMyField() {
        return myField;
    }
    ...
}