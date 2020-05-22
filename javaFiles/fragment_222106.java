public abstract class MyAbstractClass{

    @Autowired
    private MyGettableApi gettableService;

    //concrete method
    protected Object myConcreteMethod(String name){
        try{
            Object b = gettableService.getObject(name);
            return b;
        } catch(MyException e){
          LOGGER.log("ERROR THROWN" + e);
        }
    }

}  


public final class MyFinalClass implements MyGettableApi {

    @Override
    public Object getObject(String name) throws MyException{
        **** HAS NOT YET BEEN IMPLEMENTED ****
        return null;
    }

}


public interface MyGettableApi {
    public Object getObject(String name);
}