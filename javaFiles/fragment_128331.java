public class ObjectClass {
    Test parentInstance;

    public ObjectClass(Test instance){
        parentInstance = instance;
    }

    public void callMethod(){
        parentInstance.testMethod();
    }
}