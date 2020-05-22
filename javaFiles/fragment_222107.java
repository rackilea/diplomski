public abstract class MyAbstractClass{

    @Autowired
    private MyFinalClass myFinalClass;

    //concrete method
    protected Object myConcreteMethod(String name){
        try{
            Object b = myGetObjectWrapperMethod(name);
            return b;
        } catch(MyException e){
          LOGGER.log("ERROR THROWN" + e);
        }
    }

    Object myGetObjectWrapperMethod(String name) {
        return myFinalClass.getObject(name);
    }

}