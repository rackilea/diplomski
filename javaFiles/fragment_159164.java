public class SomeObject{

    public String someMethod(){
        return "Test";
    }
}

public String expectsMethodRef( Function<SomeObject, String> f ){
    SomeObject so = new SomeObject();
    return f.apply(so);
}