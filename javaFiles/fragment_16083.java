/** SuperClass.java **/
public abstract class SuperClass {

    public static void printClass(){
    System.out.println(new ImplementingClassRetriever().getCallingClass());
    }

    static class ImplementingClassRetriever extends SecurityManager{
    public Class getCallingClass() {
        Class[] classes = getClassContext();
        for (Class clazz : classes) {
        if (SuperClass.class.isAssignableFrom(clazz) && clazz != null
            && !clazz.equals(SuperClass.class)) {
            return clazz;
        }
        }
        return null;
    }
    }
}


/** Main.java **/
public class Main{
    public static void main(String[] args) {
    Sub.printClass(); //this does not work
    Sub.testStaticCall(); //this works!! :)
    }
}


class Sub extends SuperClass{

    public static void testStaticCall(){
    Sub.printClass(); //calling the method in the super class
    }
}