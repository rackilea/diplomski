public class SomeServiceImpl implements ISomeService {

    private final SomeDataDAO someDataDAO;

    @Inject
    public SomeServiceImpl(SomeDataDAO someDataDAO){
        this.someDataDAO = someDataDAO;
    }

    public void doSomeStuff(){
         someDataDAO.hai();
    }
}