public class ClassA {

    public String someAVar;

    public void callB(ClassA a){
        //do stuff
        ClassB b = new ClassB();
        b.setObjA(this,"newValue");
    }
}
public class ClassB{
    public void setObjA(ClassA A, String newValue){
        A.someAVar = newValue;
    }
}