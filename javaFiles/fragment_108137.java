public class ClassA {

    public static String someAVar;

    public void callB(){
        //do stuff
        ClassB b = new ClassB();
        b.setObjA("newValue");
    }
}


public class ClassB{
    public void setObjA(String newValue){
        ClassA.someAVar = newValue;
    }
}