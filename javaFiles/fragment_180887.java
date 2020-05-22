//here's your interface.
public interface IMyClass{
    void addOne();
    void minusOne();
}

//implement interface in MyClass.
public class MyClass implements IMyClass{/*...*/}

public class MyOtherClass{
    IMyClass myClass;
    public MyOtherClass(IMyClass myClass){
        this.myClass = myClass;
    }

    public void test(){
        myClass.addOne();
        myClass.minusOne();
    }
}