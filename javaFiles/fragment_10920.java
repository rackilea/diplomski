import lombok.Delegate;
class Wrapper {
    //the types field in the annotation says
    //to only auto generate deleagate methods
    //for only the public methods in the ObjectToWrap class
    //and not any parent classes if ObjectToWrap extended something 
    @Delegate(types = ObjectToWrap.class)
    private ObjectToWrap obj;

}